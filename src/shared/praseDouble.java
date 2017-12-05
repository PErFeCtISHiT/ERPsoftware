package shared;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 20:47 2017/12/3
 */
public class praseDouble {
    /**
    *@author:pis
    *@description: 检测转换异常的copy方法
    *@date: 11:15 2017/12/4
    */
    public static Double prase(String str){
        if(str.length() != 0 && str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            Double ret = Double.parseDouble(str);
            return ret;
        }
        return 0d;
    }
}
