package day01;
/**
 * 
 * 文档注释
 * @author planetarianZero
 * @version 1.0 17/8/21
 * @see Java.lang.String
 * @since JDK 1.0
 *
 */
public class APIDemo 
{
	/**
	 * 常量的文档注释
	 */
	public static final String text="hello";
	/**
	 * 为指定用户添加方法
	 * @param name 指定用户的名字
	 * @return 添加问候语后的字符串
	 */
	public String sayHello(String name)
	{
		return text+name;
	}
}
