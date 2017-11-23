package day01;

/**
 * 
 * StringBuilder类提供了用于修改字符串内容的相关方法
 * 其内部维护的是一个可变字符数组，所以修改是在当对象内部完成的。当频繁修改字符串内容时，应使用
 * 当前类完成。
 * 
 * StringBuilder append(String str)
 * 向字符串末尾添加指定内容，有若干重载方法，支持其他类型变量。（先转换为字符串再追加）
 * 
 * StringBuilder replace(int start,int end,String str)
 * 把指定位置的字符串替换为给定的字符串
 * 
 * StringBuilder delete(int start,int end)
 * 删除指定位置的字符串
 * 
 * StringBuilder insert(int index,String str)
 * 将给定字符串插入到指定位置，源字符串向后移动。
 * 
 * StringBuilder reverse()
 * 反转字符串
 * 
 * @author 87188
 *
 */

public class JavaStringBuilder 
{
	private static String str="HelloWorld";
	private static StringBuilder builder=new StringBuilder(str);
	public static void main(String[] args) 
	{
		TheStringBuilder();
		TheReplace();
		TheInsertAndDelect();
	}
	
	public static void TheStringBuilder()
	{
		/*
		 * 从StringBuilder转换为String时，只需使用StringBuilder的toString()方法即可。
		 * builder.toString();
		 */
		builder.append(","+str);
		System.out.println(builder.toString());
	}
	
	public static void TheReplace()
	{
		builder.replace(builder.indexOf(","),builder.lastIndexOf("d")+1, ",HelloJava");
		System.out.println(builder.toString());
	}
	
	public static void TheInsertAndDelect()
	{
		builder.insert(builder.indexOf(","), ",HelloC++");
		System.out.println(builder.toString());
		builder.delete(builder.indexOf(","), builder.lastIndexOf(","));
		System.out.println(builder.toString());
	}
}
