package client.Presentation.mainUI;

import java.net.URLEncoder;
import java.util.Objects;


/**
 * 人脸查找——识别
 */
public class Identify {
    public static final String APP_ID = "10538552";
    public static final String API_KEY = "G1bF7wdqv51QppnVn1G4hZal";
    public static final String SECRET_KEY = "FGSU13VGAshDB19ghIU2d6EGfGcG0IoH";


    public String identify() {

        String url = "https://aip.baidubce.com/rest/2.0/face/v2/identify";
        try {
            String filePath = Objects.requireNonNull(this.getClass().getClassLoader().getResource("test.jpg")).getPath();
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");


            String param = "group_id=" + "bighomework" + "&user_top_num=" + "1" + "&face_top_num=" + "1" + "&images=" + imgParam;

            String accessToken = "24.9352a81b8c30478d23ea1401ec8d48a4.2592000.1515922999.282335-10538552";

            String result = HttpUtil.post(url, accessToken, param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


