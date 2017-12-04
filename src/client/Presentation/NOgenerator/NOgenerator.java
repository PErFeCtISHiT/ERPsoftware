package client.Presentation.NOgenerator;

import client.RMI.link;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 11:28 2017/12/4
 */
public class NOgenerator {
    /**
    *@author:pis
    *@description: 编号产生器
    *@date: 11:28 2017/12/4
    */
    public static String generate(int type) throws RemoteException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        String no = "";
        List POS = link.getRemoteHelper().getPub().findAll(type);
        if(POS.isEmpty())
            no = "00001";
        else{
            String temp = "";
            BeanInfo fromBean = Introspector.getBeanInfo(POS.get(POS.size() - 1).getClass(), Object.class);
            PropertyDescriptor[] fromProperty = fromBean.getPropertyDescriptors();
            for(PropertyDescriptor i : fromProperty){
                if(i.getName().equals("keyno")){
                    temp = (String) i.getReadMethod().invoke(POS.get(POS.size() - 1));
                }
            }
            System.out.println(temp);
            String split[] = temp.split("-");
            int tempint = Integer.parseInt(split[2]);
            tempint++;
            no = String.valueOf(tempint);
            while (no.length() < 5)
                no = "0" + no;
        }
        return no;
    }
}