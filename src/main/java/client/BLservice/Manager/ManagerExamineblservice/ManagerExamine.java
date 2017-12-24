package client.BLservice.Manager.ManagerExamineblservice;

import shared.ResultMessage;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 16:07 2017/11/26
 */
public interface ManagerExamine {
    /**
     *@author:pis
     *@description: 接收小伙伴们给你的单据，具体方法参考shared/copyclass
     *@date: 16:12 2017/11/26
     */
    ResultMessage ExamineBill(Object o);
    static ResultMessage acceptBill(Object o){
        try {
            BeanInfo objectBean = Introspector.getBeanInfo(o.getClass(),Object.class);
            PropertyDescriptor[] objProperty = objectBean.getPropertyDescriptors();
        }catch (Exception e) {
            return ResultMessage.Failure;
        }
        return ResultMessage.Success;
    }
}

