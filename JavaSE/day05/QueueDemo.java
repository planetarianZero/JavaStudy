package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列
 * 队列可存放一组元素，但存取元素必须遵循先进先出原则
 * 也实现了队列接口。
 * 
 * boolean offer(E e)
 * 入队操作，向队尾添加一个元素
 * 
 * E poll()
 *  在队首取出一个元素，取出后该元素就被删除
 *  
 * E peek()
 * 引用队首元素，但不做出队操作
 * @author planetarianZero
 */

public class QueueDemo 
{
	public static void main(String[] agrs)
	{
		Demo1();
	}
	public static void Demo1()
	{
		Queue<String> q=new LinkedList<String>();
		q.offer("one");
		q.offer("two");
		q.offer("three");
		q.offer("four");
		System.out.println(q);
		String str=q.poll();
		System.out.println(str);
		str=q.peek();
		System.out.println(str+q);
		//队列的遍历，建议使用while(q.size()>0)循环
		for(int i=q.size();i>0;i--)
		{
			str=q.poll();
			System.out.println(str);
		}
		System.out.println(q);
	}

}
