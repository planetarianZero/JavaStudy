package day02;
/**
 * 字符串支持正则表达式的方法:
 * boolean matches(String regex)
 * 根据给定的正则表达式验证当前字符串是否满足格式
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分，返回拆分后的每段内容，即移除符合正则表达式的部分
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为指定字符串
 * @author planetarianZero
 */
public class StringDemo1 
{
	public static void main(String args[])
	{
		String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+";
		String regex_2="[1][\\d]{10}";
		String regex_3="[0-9]+";
		String mail="planetarian@mail.com";
		String phone="12345678901";
		String test="abc123def456ghi789";
		boolean flag=mail.matches(regex);
		boolean flag_2=phone.matches(regex_2);
		String[] array=test.split(regex_3);
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		System.out.println(flag);
		System.out.println(flag_2);
		changeFileName();
		replace();
	}
	
	public static void changeFileName()//文件重命名
	{
		String fileName="1.jpg";
		String regex="\\.";
		String newName[]=fileName.split(regex);
		fileName=System.currentTimeMillis()+"."+newName[1];
		System.out.println(fileName);
	}
	
	public static void replace()//替换
	{
		String regex="[\\d]+";
		String str="abc123def456ghi789";
		str=str.replaceAll(regex, "#num#");
		System.out.println(str);
	}
}
