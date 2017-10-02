package day05;

import java.util.*;

/**
 * sort要求集合元素必须实现Comparable接口，该接口规定实现类是可以比较的
 * 其中有一个抽象方法是用来定义比较大小的规则
 * 
 * 我们想使用sort方法来排序集合，但该方法必须要求我们实现Comparable接口，并且定义比较规则，
 * 这种我们想使用某个功能，而他要求我们修改程序的现象称为“侵入性”，侵入性越强，越不利于程序扩展
 * 
 * @author planetarianZero
 *
 */
public class SortListDemo 
{
	public static void main(String[] args) 
	{
		Demo1();
	}
	public static void Demo1()
	{
		List<String> l=new ArrayList<String>();
		l.add("qwerqw");
		l.add("two");
		l.add("three");
		MyComparable com=new MyComparable();
		Collections.sort(l,com);
		System.out.println(l);
		//推荐使用匿名内部类形式创建
		Comparator<String> com1=new Comparator<String>() 
		{
			public int compare(String o1, String o2) 
			{
				return o2.length()-o1.length();
			}
		};
		Collections.sort(l,com1);
		System.out.println(l);
	}
}
class MyComparable implements Comparator<String>
{
	public int compare(String o1, String o2) 
	{
		return o1.length()-o2.length();
	}
}
