package client.Presentation.mainUI;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class FaceUpload {

    public static void main(String[] args) throws IOException, InterruptedException {
        String username = "";
        username = "yitongxiaoerzi";
        //此处解析userpo 更换username

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.setImageWidth(800);
        grabber.setImageHeight(640);
        grabber.start();


        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        opencv_core.IplImage grabbedImage = converter.convertToIplImage(grabber.grab());
        CanvasFrame frame = new CanvasFrame("Some Title", CanvasFrame.getDefaultGamma() / grabber.getGamma());

        JPanel contentPane = new JPanel();
        Container contentPane2 = frame.getContentPane();


        JButton save_photo = new JButton("上传");
        JButton cancle = new JButton("返回");
        Camera camera = new Camera();

        save_photo.addMouseListener(new UploadPhotoMouseAdapter(grabbedImage, username));


        //返回需要自行添加 此处默认为关闭
        cancle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                frame.dispose();
                frame.setVisible(false);
            }
        });


        contentPane.add(save_photo, BorderLayout.SOUTH);

        contentPane.add(cancle, BorderLayout.SOUTH);

        contentPane2.add(contentPane, BorderLayout.SOUTH);

        while (frame.isVisible()) {


            if (camera.getState()) {
                grabbedImage = converter.convert(grabber.grab());
            }
            frame.showImage(converter.convert(grabbedImage));
            Thread.sleep(40);
        }

        grabber.stop();
        frame.dispose();


    }


}


class UploadPhotoMouseAdapter extends MouseAdapter {


    private IplImage iplImage;
    private String picName;

    public UploadPhotoMouseAdapter(IplImage iplImage, String pic) {
        this.iplImage = iplImage;
        this.picName = pic;
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("保存");


        JFrame myFrame = new JFrame();
        try {
            if (iplImage != null) {
                String fpath = picName + ".jpg";
                cvSaveImage(fpath, iplImage);
                String mess = FaceAdd.add(picName);


            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            myFrame.dispose();
            myFrame = null;

        }
    }


    public static void cvSaveImage(String path, IplImage image) throws IOException {
        File file = new File(path);


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(toBufferedImage(image), "jpg", out);
        byte[] bs = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bs, 0, bs.length);
        fos.close();

        out.close();
    }


// 通过image获取bufferedImage

    public static BufferedImage toBufferedImage(IplImage image) {
        OpenCVFrameConverter.ToIplImage iplConverter = new OpenCVFrameConverter.ToIplImage();
        Java2DFrameConverter java2dConverter = new Java2DFrameConverter();
        BufferedImage bufferedImage = java2dConverter.convert(iplConverter.convert(image));
        return bufferedImage;
    }

}




