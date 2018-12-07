package com.nuoxin.virtual.rep.api;

import com.nuoxin.virtual.rep.api.utils.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fenggang on 10/13/17.
 */
public class StringTest {

    /**
     * 正则表达式匹配两个指定字符串中间的内容
     * @param soap
     * @return
     */
    public static List<String> getSubUtil(String soap, String rgex){
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
//        String str = "sadffa<u>&nbsp;</u>fasdf<u>&nbsp;&nbsp;&nbs</u>fsg<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>fgs";
//        String rgex = "<u>(.*?)</u>";
//        System.out.println(getSubUtil(str,rgex));
//        System.out.println(getSubUtilSimple(str, rgex));
//        String[] dates = "2017-09-01".split("-");
//        Calendar a = Calendar.getInstance();
//        a.set(Integer.valueOf(dates[0]),Integer.valueOf(dates[1])-1,1,0,0,0);
//        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
//        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
//        int maxDate = a.get(Calendar.DATE);
//        System.out.println(maxDate);
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH,16);
//        calendar.set(2017,9,16,0,0,0);
//        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
//        if(weekDay==1){
//            System.out.println(DateUtil.getDateTimeString(calendar.getTime()));
//            calendar.add(Calendar.DAY_OF_YEAR,-6);
//            System.out.println(DateUtil.getDateTimeString(calendar.getTime()));
//        }else{
//            calendar.add(Calendar.DAY_OF_YEAR,2-weekDay);
//            System.out.println(DateUtil.getDateTimeString(calendar.getTime()));
//            calendar.add(Calendar.DAY_OF_YEAR,9-weekDay);
//            System.out.println(DateUtil.getDateTimeString(calendar.getTime()));
//        }
//
//        calendar.set(2017,((int) calendar.get(Calendar.MONTH) / 3) * 3,1,0,0,0);
//        System.out.println(DateUtil.getDateTimeString(calendar.getTime()));
//        calendar.set(2017,((int) calendar.get(Calendar.MONTH) / 3) * 3 + 2,1,0,0,0);
//        calendar.add(Calendar.MONTH,+1);
//        System.out.println(DateUtil.getDateTimeString(calendar.getTime()));
        System.out.print(_computationsDateNum(DateUtil.getDateFromStr("2017-12-01 00:00:00"),new Date()));
    }

    private static int _computationsDateNum(Date start, Date end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(start);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }
}