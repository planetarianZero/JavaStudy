package day02;
/**
 * 包装类
 * Java对于8个基本类型分别定义了对应的包装类，出现原因是解决不能面向对象开发的问题
 * 数字类型的包装类继承自Number
 * 提供了如intValue，doubleValue等方法，作用是将当前包装类的数字以其他数字类型的形式返回
 * @author planetarianZero
 *
 */
public class IntegerDemo 
{
	public static void main(String args[])
	{
		Integer i=new Integer(1);
		Integer i2=Integer.valueOf(10);//推荐使用valueOf方法
	}
}
