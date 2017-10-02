package day01;

public class StringDemo 
{
	public static void main(String[] args) 
	{
		int a=123;
		String test = "java";
		String test_2="abcdefghijkmlnopqrstuvwxyz";
		StringBuilder builder=new StringBuilder(test);
		int index=test.indexOf("a");//返回该字符串在当前字符串出现的第一个位置,-1为不存在
		int index_2=test.indexOf("a", 1);//从指定位置开始寻找指定字符串，返回的还是整个字符串中的位置
		int index_3=test.lastIndexOf("a");//返回指定字符串在该字符串中最后出现的位置
		String sub=test_2.substring(0, 4);//截取abcd，含头不含尾
		String sub_2=test_2.substring(4);//从头截到尾
		char select=test_2.charAt(7);//返回第七个字符
		String Upper=test.toUpperCase();//返回大写
		String lower=test.toLowerCase();//返回小写
		String value=String.valueOf(a);//将参数数据转换为字符串变量，多个重载
		builder.append("add,new");//在原基础之上添加新的字符串
		builder.replace(0, 2, "asdasd");//将指定范围的字符串替换为参数字符串
		builder.delete(0, 2);//删除指定位置字符串
		builder.insert(0, "new");//在指定位置插入新的字符串
		builder.reverse();//反转字符串
		//builder.toString();//还原回字符串
		System.out.println(test.length());
		System.out.println(index);
		System.out.println(index_2);
		System.out.println(index_3);
		System.out.println(sub);
		System.out.println(sub_2);
		System.out.println(select);
		System.out.println(Upper);
		System.out.println(lower);
		System.out.println(value);
	}
}
