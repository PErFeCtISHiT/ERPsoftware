package client.Presentation.mainUI;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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


public class FaceLogin {

    public static void main(String[] args) throws IOException, InterruptedException {

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.setImageWidth(800);
        grabber.setImageHeight(640);
        grabber.start();


        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        opencv_core.IplImage grabbedImage = converter.convertToIplImage(grabber.grab());
        CanvasFrame frame = new CanvasFrame("Some Title", CanvasFrame.getDefaultGamma() / grabber.getGamma());

        JPanel contentPane = new JPanel();
        Container contentPane2 = frame.getContentPane();


        JButton save_photo = new JButton("登录");
        JButton cancle = new JButton("关闭");
        Camera camera = new Camera();

        save_photo.addMouseListener(new SavePhotoMouseAdapter(grabbedImage));

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


class SavePhotoMouseAdapter extends MouseAdapter {


    private IplImage iplImage;

    public SavePhotoMouseAdapter(IplImage iplImage) {
        this.iplImage = iplImage;
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("保存");


        JFrame myFrame = new JFrame();
        try {
            if (iplImage != null) {

                cvSaveImage("test.jpg", iplImage);
                String s = Identify.identify();
                JsonObject obj = new JsonParser().parse(s).getAsJsonObject();
                JsonArray body = obj.get("result").getAsJsonArray();
                String name = "";
                double finalscore = 0;
                for (JsonElement jsonElement : body) {
                    JsonObject jo = jsonElement.getAsJsonObject();
                    name = jo.get("uid").getAsString();
                    JsonArray score = jo.get("scores").getAsJsonArray();
                    finalscore = score.get(0).getAsDouble();

                }

                if (finalscore > 80) {
                    JOptionPane.showMessageDialog(myFrame, "登录成功");
                } else {
                    JOptionPane.showMessageDialog(myFrame, "登录失败");
                }


            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            myFrame.setVisible(false);

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

class TakePhotoMouseAdapter extends MouseAdapter {


    private JButton jButton;
    private Camera camera;


    public TakePhotoMouseAdapter(JButton jButton, Camera camera) {
        this.jButton = jButton;
        this.camera = camera;
    }


}


class Camera {

    private Boolean state = true;


    public Boolean getState() {
        return state;
    }


    public void setState(Boolean state) {
        this.state = state;
    }


}
