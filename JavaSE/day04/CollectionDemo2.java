package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
/**
 * boolean remove(E e)
 * 删除集合中第一个与参数匹配的元素
 * 
 * 集合的批量操作
 * 取并集
 * boolean addAll(Collection c)
 * 将给定集合的所有元素添加到集合中，只要集合发生变化，就返回true
 * boolean containsAll(Collection c)
 * 判断当前集合是否包含给定集合中的所有元素
 * void removeAll(Collection c)
 * 删除指定集合中参数C包含的所有元素
 * 
 * 遍历集合 
 * java.util.Iterator是一个接口，规定了用于遍历集合元素的相关方法。
 * 迭代器模式
 * Iterator iterator()
 * 获取用于遍历当前集合的迭代器
 * 
 * 增强for循环(或称之为for each)
 * 只用于遍历集合或数组
 * 
 * @author planetarianZero
 *
 */
public class CollectionDemo2 
{
	public static void main(String[] args) 
	{
		Demo_1();
		Demo_2();
	}
	public static void Demo_1()
	{
		Collection c=new ArrayList();
		Collection s=new HashSet();
		c.add("1");
		c.add("#");
		c.add("2");
		c.add("#");
		c.add("3");
		c.add("#");
		c.add("4");
		Iterator it=c.iterator();//获取遍历当前集合的迭代器
		while(it.hasNext())
		{
			Object o=it.next();
			if("#".equals(o))//建议，如果反过来写，可能引发空指向异常
			{
				/*
				 * 在使用迭代器遍历时，不要使用集合的方法增删元素，否则会引发异常
				 * c.remove(o);
				 */
				it.remove();
			}
			System.out.println(o);
		}
		System.out.println(c);
	}
	public static void Demo_2()
	{
		Collection c=new ArrayList();
		c.add(1);
		c.add(2);
		c.add(3);
		int[] array={1,2,3};
		for(int list:array)
		{
			System.out.print(list);
		}
		System.out.println();
		/*
		 * 新循环就是迭代器，无法使用集合的方法更改元素
		 */
		for(Object o:c)
		{
			System.out.print(o);
		}
		System.out.println();
	}
}
