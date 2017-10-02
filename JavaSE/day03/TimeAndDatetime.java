package day03;

import java.util.*;
import java.text.*;

/**
 * 日期类
 * Java.util.Date
 * 内部维护了一个long值，该值从1970年1月1日0：0：0到表示的时间点之间经历的毫秒值，大多数方法已过时
 * 
 * 日期与字符串的转换
 * java.text.SimpleDateFormat
 * 根据给定的日期格式将string和date进行互转
 * String format(Date date)
 * 该方法可以将给定的date对象所标示的时间按照SimpleDateFormat指定的格式进行转换为字符串
 * Date parse(String str)
 * 该方法可以将给定的String对象所标示的时间按照SimpleDateFormat指定的格式进行转换为日期
 * 
 * 日历类（抽象类）
 * java.util.Calendar
 * 常用的实现类是阳历（格里高利历），主要作用是计算时间
 * 该类的toString方法可读性差
 * Date getTime()
 * Calendar提供了getTime方法来返回一个Date对象，该对象表示的时间就是当前Calendar表示的时间
 * void set(int field,int value)
 * 针对不同时间分量单独设置值的方法
 * 其中第一个参数为时间分量，如日月年，第二个参数为对应的值
 * int get(int field)
 * 获取对应时间分量的值
 * int getActualMaximum(int field)
 * 获取该时间分量的最大值，常用于年和月
 * void add(int field int value)
 * 对指定的时间分量加上指定的值，若值为负数，则减去给定的值
 * 
 * @author planetarianZero
 */
public class TimeAndDatetime 
{
	public static void main(String args[]) throws ParseException
	{
		Date now=new Date();
		SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdt.format(now);
		System.out.println(str);
		toDate();
		calenderDemo();
		maxFiled();
		mathOfCalender();
	}
	public static void toDate() throws ParseException
	{
		String str="2017-8-23 20:41:00";
		SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdt.parse(str);
		System.out.println(date);
	}
	public static void calenderDemo()
	{
		Calendar ca=Calendar.getInstance();//该方法会根据系统所在地创建一个相应实现，默认创建的日历实例表示当前系统时间
		Date date=ca.getTime();
		SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdt.format(date);
		System.out.println(str);
		
		ca.set(Calendar.YEAR, 2008);
		ca.set(Calendar.MONTH, Calendar.JANUARY);//月份从0开始，建议使用常量
		ca.set(Calendar.DATE, 10);//常用的时间分量：DATE月中天；DAY_OF_MONTH与DATE一致；DAY_OF_WEEK星期几；DAY_OF_YEAR年中天
		ca.set(Calendar.HOUR_OF_DAY,20);
		
		int year=ca.get(Calendar.YEAR);
		int day=ca.get(Calendar.DAY_OF_YEAR);//查看一年中过了多少天
		
		System.out.println(ca.getTime());
		System.out.println(year);
		System.out.println(day);
	}
	public static void maxFiled()
	{
		Calendar ca=Calendar.getInstance();
		int days=ca.getActualMaximum(Calendar.DATE);//该月最多多少天？
		System.out.println(days);
	}
	public static void mathOfCalender()
	{
		Calendar ca=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ca.add(Calendar.YEAR, 3);
		ca.add(Calendar.MONTH, 2);
		ca.add(Calendar.DAY_OF_YEAR ,20);//加上3年2个月20天后的日期
		Date date=ca.getTime();
		String str=sdf.format(date);
		System.out.println(str);
	}
	public static void DateBuildDemo()
	{
		/*
		 * 基本流程：
		 * 获取用户输入的日期字符串
		 * 使用SimpleDateFormat将其转换为Date类型
		 * 创建一个Calendar，使其表示Date表示的日期
		 * 使用Calendar根据需求计算时间
		 * 将Calendar转换成一个Date
		 * 使用SimpleDateFormat将Date转换成字符串后显示给用户
		 */
	}
}
