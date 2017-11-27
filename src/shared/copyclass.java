package shared;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class copyclass {
    public static void copy(Object from,Object to){
        try {


            BeanInfo fromBean = Introspector.getBeanInfo(from.getClass(), Object.class);
            PropertyDescriptor[] fromProperty = fromBean.getPropertyDescriptors();
            BeanInfo toBean = Introspector.getBeanInfo(to.getClass(), Object.class);
            PropertyDescriptor[] toProperty = toBean.getPropertyDescriptors();
            for (int i = 0; i < fromProperty.length; i++) {
                for (int j = 0; j < toProperty.length; j++) {
                    if (fromProperty[i].getName().equals(toProperty[j].getName()) && fromProperty[i].getPropertyType() == toProperty[j].getPropertyType()) {
                        toProperty[j].getWriteMethod().invoke(to, fromProperty[i].getReadMethod().invoke(from));
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
