package client.Presentation.mainUI;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;


import java.net.URLEncoder;

/**
 * 人脸注册
 */
public class FaceAdd {
    public static final String APP_ID = "10538552";
    public static final String API_KEY = "G1bF7wdqv51QppnVn1G4hZal";
    public static final String SECRET_KEY = "FGSU13VGAshDB19ghIU2d6EGfGcG0IoH";


    public static String add(String name) {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add";
        String access_token_url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials"
                +"&client_id="+API_KEY +"&client_secret="+SECRET_KEY;
        System.out.println(access_token_url);
        try {
            // 本地文件路径

            String filePath = name+".jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

//            String param = "uid=" + "test_user_5" + "&user_info=" + "userInfo5" + "&group_id=" + "test_group_2" + "&images=" + imgParam + "," + imgParam2;
            String param = "uid=" + name + "&user_info=" + "group-number" + "&group_id=" + "bighomework" + "&images=" + imgParam ;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.9352a81b8c30478d23ea1401ec8d48a4.2592000.1515922999.282335-10538552";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
