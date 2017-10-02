package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合类
 * java.util.Collection
 * 用于创建集合，其下派生出两个子类接口List和Set，集合存放的是元素的引用，即地址
 * 其中List为可重复集
 * Set为不可重复集
 * 元素是否重复依靠自身的equals方法比较的结果而定
 * boolean add(E e)
 * 向集合中添加一个元素
 * int size()
 * 返回当前元素个数
 * boolean isEmpty()
 * 判断当前集合是否为空
 * void clear()
 * 清空当前集合所有元素
 * boolean contains(E e)
 * 判断当前集合是否包含给定元素
 * @author planetarianZero
 */

public class CollectionDemo 
{
	public static void main(String args[])
	{
		buildCollection();
	}
	public static void buildCollection()
	{
		Collection c=new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.contains("c"));//若使用自定义的类，且自定义类中没有重写equals方法
											//，则返回值为false，因为直接调用的是Object类中的equals方法
	}
}
