package client.Presentation.mainUI;

import client.RMI.link;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import server.Po.userPO;
import shared.Identify;

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
import java.util.Objects;

/**
 * @author: ferrycore
 * @description: nullptr
 */
class SavePhotoMouseAdapter extends MouseAdapter {


    private opencv_core.IplImage iplImage;
    private Frame frame;
    private Stage stage;

    SavePhotoMouseAdapter(opencv_core.IplImage iplImage, Frame frame, Stage stage) {
        this.iplImage = iplImage;
        this.frame = frame;
        this.stage = stage;
    }

    private SavePhotoMouseAdapter() {

    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        JFrame myFrame = new JFrame();


        SavePhotoMouseAdapter savePhotoMouseAdapter = new SavePhotoMouseAdapter();
        try {
            if (iplImage != null) {

                savePhotoMouseAdapter.cvSaveImage(iplImage);
                Identify identify = new Identify();
                String s = identify.identify();
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
                final String finalname = name;
                userPO thisPO = new userPO();


                if (finalscore > 80) {
                    String newstr = finalname;
                    if (newstr.equals("yitongxiaoerzi"))
                        newstr = "somnus";
                    String password = link.getRemoteHelper().getUser().getpasswordByName(newstr);
                    userPO userPO = (server.Po.userPO) link.getRemoteHelper().getUser().login(newstr, password).get(0);
                    userPO.setEmail("face");
                    link.getRemoteHelper().getUser().modifyObject(userPO, 15);
                    fxlogin fxlogin = new fxlogin(newstr,stage);
                    Platform.runLater(fxlogin);
                    frame.dispose();
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


    private void cvSaveImage(opencv_core.IplImage image) throws IOException {
        File file = new File(this.getClass().getClassLoader().getResource("test.jpg").toString());


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
