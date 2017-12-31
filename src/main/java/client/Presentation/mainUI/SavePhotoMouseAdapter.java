package client.Presentation.mainUI;

import client.RMI.link;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.stage.Stage;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import server.Po.userPO;

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
 * @date: create in 9:18 2017/12/31
 */
class SavePhotoMouseAdapter extends MouseAdapter {


    private opencv_core.IplImage iplImage;

    SavePhotoMouseAdapter(opencv_core.IplImage iplImage) {
        this.iplImage = iplImage;
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        JFrame myFrame = new JFrame();
        try {
            if (iplImage != null) {

                cvSaveImage(iplImage);
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
                    String password = link.getRemoteHelper().getUser().getpasswordByName(name);
                    userPO userPO = (server.Po.userPO) link.getRemoteHelper().getUser().login(name,password).get(0);
                    Stage stage = new Stage();
                    StartUI startUI = new StartUI();
                    startUI.login(userPO,stage);
                    myFrame.dispose();

                } else {
                    JOptionPane.showMessageDialog(myFrame, "登录失败");
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            myFrame.setVisible(false);

        }
    }


    private static void cvSaveImage(opencv_core.IplImage image) throws IOException {
        File file = new File("resource.test.jpg");


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
