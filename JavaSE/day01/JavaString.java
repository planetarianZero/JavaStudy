package day01;

/**
 * String类常用方法
 * 
 * int length()
 * 获取字符串长度，无论中文还是英文都是一个长度，返回字符串下标，若返回-1表示没有该字符串
 * 
 * int indexOf(String str)
 * 查找给定字符串在当前字符串中的位置，该方法有几个重载方法
 * 
 * int lastIndexOf(String str)
 * 查找给定字符串在当前字符串中最后出现的位置
 * 
 * String substring(int start,int end)
 * 截取字符串，从指定位置（start）开始，到指定位置（end）结束，截取的字符串包含开始位置，不包含
 * 结束位置
 * 
 * char charAt(int index)
 * 获取当前字符串指定下标的字符
 * 
 * boolean startWith(String str)
 * boolean endsWith(String str)
 * 字符串是否以指定字符串开始或结束
 * 
 * String toUpperCase()
 * String toLowerCase()
 * 将字符串转换为大写或小写
 * 
 * 若干静态方法
 * static String valueOf(XXX xxx)
 * 将Java中的其他类型转换为字符串
 * 
 * @author admin
 *
 */

public class JavaString 
{
	private static String str="HelloWorld";
	public static void main(String[] args) 
	{
		TheStringIndex();
		TheSubString();
		TheCharAt();
		TheStartOrEnd();
		TheUpperOrLower();
		TheValueOf();
	}
	
	public static void TheStringIndex()
	{
		int index=str.indexOf("H");
		int theNull=str.indexOf("S");
		System.out.println(index);
		System.out.println(theNull);
		/*
		 * 重载方法允许从指定位置开始查找
		 */
		index=str.indexOf("W", 4);
		System.out.println(index);
		
		index=str.lastIndexOf("o");
		System.out.println(index);	
	}
	
	public static void TheSubString()
	{
		String host="www.tedu.com.cn";
		String sub=str.substring(5, 10);
		System.out.println(sub);
		
		sub=host.substring(host.indexOf(".")+1, host.indexOf(".",host.indexOf(".")+1));
		System.out.println(sub);
	}
	
	public static void TheCharAt()
	{
		System.out.println(str.charAt(5));
		String text="abcdcba";
		for(int i=0;i<text.length()/2;i++)
		{
			if(text.charAt(i)!=text.charAt(text.length()-i-1))
			{
				System.out.println("不是回文");
				return;
			}
		}
		System.out.println("是回文");
	}
	
	public static void TheStartOrEnd()
	{
		System.out.println(str.startsWith("H")+":"+str.endsWith("d"));
	}
	
	public static void TheUpperOrLower()
	{
		System.out.println("全大写："+str.toUpperCase()+":"+"全小写："+str.toLowerCase());
	}
	
	public static void TheValueOf()
	{
		System.out.println(String.valueOf(12));
	}
}
