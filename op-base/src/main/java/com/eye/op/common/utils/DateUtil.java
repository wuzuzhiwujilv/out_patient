package com.eye.op.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date getCurrentDate(){
		return new Date();
	}
	public static boolean isBetween(Date date,Date start,Date end){
		if(date.getTime()>=start.getTime()&&date.getTime()<=end.getTime())
			return true;
		return false;
	}
	public static boolean isBetweenNoEq(Date date,Date start,Date end){
		if(date.getTime()>start.getTime()&&date.getTime()<end.getTime())
			return true;
		return false;
	}
	public static boolean isLET(Date d1,Date d2){
		return d1.getTime()<=d2.getTime();
	}
	public static boolean isGET(Date d1,Date d2){
		return d1.getTime()>=d2.getTime();
	}
	public static boolean isLT(Date d1,Date d2){
		return d1.getTime()<d2.getTime();
	}
	public static boolean isGT(Date d1,Date d2){
		return d1.getTime()>d2.getTime();
	}
	public static boolean isEQ(Date d1,Date d2){
		if(d1==null||d2==null){
			return false;
		}
		return d1.getTime()==d2.getTime();
	}
	public static  String getTime(){
		Date time=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(time);
	}
	
	public static Date addOneDay(Date date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(sdf.format(cal.getTime()));
		return d;
	}
	
	public static Date addDays(Date date, int days) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(sdf.format(cal.getTime()));
		return d;
	}
	
	public static Date minOneDay(Date date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(sdf.format(cal.getTime()));
		return d;
	}
	
	public static Date minDays(Date date, int days) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		cal.add(Calendar.DATE, -days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(sdf.format(cal.getTime()));
		return d;
	}
	public static Date getMinDate(Date d1,Date d2){
		if(d1==null){
			return d2;
		}
		if(d2==null){
			return d1;
		}
		return isLT(d1,d2)?d1:d2;
	}
	
	public static Date getMinEqDate(Date d1,Date d2){
		if(d1==null){
			return d2;
		}
		if(d2==null){
			return d1;
		}
		if(d1.getTime()<=d2.getTime()){
			return d1;
		}
		return d2;
	}
	
	public static Date getMaxEqDate(Date d1,Date d2){
		if(d1==null){
			return d2;
		}
		if(d2==null){
			return d1;
		}
		if(d1.getTime()<=d2.getTime()){
			return d2;
		}
		return d1;
	}
	
	public static String formatToString(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	public static String formatToStringByformatter(Date d,String formatter){
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(d);
	}
	public static Date formatToDate(Date d)  throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(d));
		return date;
	}
	public static Date formatToDate(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(d);
		return date;
	}
	public static Date formatToDateByformatter(String d,String formatterOfd)  throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(formatterOfd);
		formatter.setLenient(false);
		Date date = formatter.parse(d);
		return date;
	}
	public static String getNowHM(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int m = calendar.get(Calendar.MINUTE); 
		if(m<45){
			calendar.add(Calendar.HOUR, 1);
		}else{
			calendar.add(Calendar.HOUR, 2);
		}
		int h = calendar.get(Calendar.HOUR_OF_DAY); 
		return h+":00";
	}
	public static String getCrossCellStartDate(Date d,String behind){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date())+" "+behind;
	}
	public static String getCrossCellEndDate(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d)+" 23:59";
	}
}
