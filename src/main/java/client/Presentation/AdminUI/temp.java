package client.Presentation.AdminUI;

import client.Presentation.mainUI.Camera;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class temp {


    public void start(String username) throws IOException, InterruptedException {


        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1);

        grabber.setImageWidth(800);

        grabber.setImageHeight(640);

        grabber.start();


        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

        IplImage grabbedImage = converter.convertToIplImage(grabber.grab());

        CanvasFrame frame = new CanvasFrame("人脸注册", CanvasFrame.getDefaultGamma() / grabber.getGamma());


        JPanel contentPane = new JPanel();

        Container contentPane2 = frame.getContentPane();


        JButton save_photo = new JButton("上传");

        JButton cancle = new JButton("返回");

        Camera camera = new Camera();


        save_photo.addMouseListener(new UploadPhotoMouseAdapter(grabbedImage, username, frame));


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







