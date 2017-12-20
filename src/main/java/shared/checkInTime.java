package shared;

import javax.persistence.criteria.CriteriaBuilder;

public class checkInTime {
    /**
     * 最好的设计方式是输入结束时间时不允许输入早于或等于之前的值 并且符合年月日基本逻辑 所以此处逻辑未写
     * 此处默认为闭集合
     * @param beginTime ..
     * @param endTime ..
     * @return ..
     * @author: Ferry Core
     */
    public static Boolean checkIsInTime(String beginTime,String endTime,String id){
        int begintime =Integer.parseInt(beginTime);
        int endtime =Integer.parseInt(endTime);
        int beginindex =id.charAt('-');
        int detectedtime = Integer.parseInt(id.substring(beginindex+1,beginindex+9));
        return detectedtime >= begintime && detectedtime <= endtime;

    }

}