package com.zucc.circle.summerwork.Util;

import android.text.Html;
import android.text.Spanned;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;

/**
 * Created by 圆圈 on 2017-07-02.
 */

public class StringUtils {


    public static int toInt(String str, int defValue) {
        try{
            return Integer.parseInt(str);
        }catch(Exception e){}
        return defValue;
    }


    public static int toInt(Object obj) {
        if(obj==null) return 0;
        return toInt(obj.toString(),0);
    }


    public static boolean isEmpty( String input )
    {
        if ( input == null || "".equals( input ) )
            return true;

        for ( int i = 0; i < input.length(); i++ )
        {
            char c = input.charAt( i );
            if ( c != ' ' && c != '\t' && c != '\r' && c != '\n' )
            {
                return false;
            }
        }
        return true;
    }

    public static String clearString(String content){
        if(content.indexOf("<img")!=-1){
            int i = content.indexOf("<img");
            int j = content.indexOf("/>");
            content =  content.substring(0,  i) +content.substring(j+2,  content.length());
        }

        if(content.indexOf("<div")!=-1){
            int i = content.indexOf("<div");
            int j = content.indexOf("</div>");
            content =  content.substring(0,  i) +content.substring(j+6,  content.length());
        }

        return content;
    }

    public static Long getlongDate() {
        long str= System.currentTimeMillis()/1000;
        return str;
    }

    public static String getDate() {
        SimpleDateFormat sDateFormat   =   new   SimpleDateFormat("hh:mm");
        String   date   =   sDateFormat.format(new   java.util.Date());
        return date;
    }



    public static String URLDecoder(String code){
        if(code == null || code.equals("")){
            return null;
        }
        String urlStr = null;
        try {
            urlStr = URLDecoder.decode(code, "gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlStr;
    }

    public static String TimeProcess(String time){
        if(time == null || time.equals("")){
            return null;
        }
        String[] co= time.split(" ");
        return co[0];
    }



    public static String getTime(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        timeStr = timeStr.replace("T", " ");
        int point = timeStr.lastIndexOf(':');
        if (point != -1) {
            return timeStr.substring(0, point);
        } else {
            return timeStr;
        }
    }

    public static String TimeProcessTODAY(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(0, 10);
    }

    public static String TimeProcessToMouthAndDay(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(5, 10);
    }

    public static String TimeProcessToTime(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(10,16);
    }

    public static String TimeProcessToYear(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(0,4);
    }

    public static String TimeProcessToMouth(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(5,7);
    }

    public static String TimeProcessToDay(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(8,10);
    }




    public static String CourseDetailTime(String timeStr1,String timeStr2){
        if (StringUtils.isEmpty(timeStr1)||StringUtils.isEmpty(timeStr2)) {
            return "";
        }

        String data = timeStr1.substring(0, 10);
        String time = timeStr1.substring(11, 16) + "-" + timeStr2.substring(11, 16);

        return data + " " + time ;
    }



    public static String TimeNoPay(String timeStr){
        if (StringUtils.isEmpty(timeStr)) {
            return "";
        }
        return timeStr.substring(0,16);
    }

    public static String YwuOrderTime(String timeStr1,String timeStr2){
        if (StringUtils.isEmpty(timeStr1)||StringUtils.isEmpty(timeStr2)) {
            return "";
        }

        String data = timeStr1.substring(0, 10);
        String time = timeStr1.substring(11, 19) ;

        return data + " " + time ;
    }




    public static Spanned replaceHTML(String str){
        return  Html.fromHtml(str);
    }
}
