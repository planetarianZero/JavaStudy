package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 存取元素必须遵循先进后出原则
 * 
 * java.util.Deque
 * 双端队列
 * 两端都可以进出队，当只调用从一端进出队操作时，就形成了栈结构
 * 因此提供了两个方法，pop，push
 * @author planetarianZero
 *
 */
public class StackDemo 
{
	public static void main(String[] args) 
	{
		Demo1();
	}
	public static void Demo1()
	{
		Deque<String> d=new LinkedList<String>();
		d.push("one");
		d.push("two");
		d.push("three");
		d.push("four");
		System.out.println(d);
	}
}
