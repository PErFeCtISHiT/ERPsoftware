package client.Presentation.AdminUI;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 20:34 2017/12/31
 */
class UploadPhotoMouseAdapter extends MouseAdapter {





    private opencv_core.IplImage iplImage;

    private String picName;

    UploadPhotoMouseAdapter(opencv_core.IplImage iplImage, String pic) {

        this.iplImage = iplImage;

        this.picName =pic;

    }





    @Override

    public void mouseClicked(MouseEvent arg0) {


        System.out.println("保存");



        JFrame myFrame = new JFrame();

        try {

            if (iplImage != null) {

                String fpath =picName+".jpg";

                cvSaveImage(fpath, iplImage);







            }

        } catch (IOException e) {



            e.printStackTrace();

        } finally {



            myFrame.dispose();


        }

    }





    private static void cvSaveImage(String path, opencv_core.IplImage image) throws IOException {

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



    private static BufferedImage toBufferedImage(opencv_core.IplImage image) {

        OpenCVFrameConverter.ToIplImage iplConverter = new OpenCVFrameConverter.ToIplImage();

        Java2DFrameConverter java2dConverter = new Java2DFrameConverter();

        return java2dConverter.convert(iplConverter.convert(image));

    }



}
