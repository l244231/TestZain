/*
 * @(#)test.java
 * Author : zixian.luo001
 * Created Date: 2017年7月10日 
 */
package com.arithmetic;

/**
 * @title 计算经纬度之间距离 
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 2017年7月10日 zixian.luo001 create file<br>
 * Id:test.java,v1.0 2017年7月10日 上午11:01:08
 */
public class Distance {
	//地球平均半径  
    private static final double EARTH_RADIUS = 6378137;  
    //把经纬度转为度（°）  
    private static double rad(double d){  
       return d * Math.PI / 180.0;  
    }  
      
    /**  
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米  
     * @param lng1  
     * @param lat1  
     * @param lng2  
     * @param lat2  
     * @return  
     */  
    public static double getDistance(double lng1, double lat1, double lng2, double lat2){  
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;  
       double b = rad(lng1) - rad(lng2);  
       double s = 2 * Math.asin(  
            Math.sqrt(  
                Math.pow(Math.sin(a/2),2)   
                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)  
            )  
        );  
       s = s * EARTH_RADIUS;  
       s = Math.round(s * 10000) / 10000;  
       return s;  
    }  
      
      
    /**  
     * test  
     * @param args  
     */  
    public static void main(String[] args){  
        double distance = getDistance(114.237920,22.715680,114.244210,22.709151);  
        System.out.println("Distance is:"+distance);  
    }  
}
