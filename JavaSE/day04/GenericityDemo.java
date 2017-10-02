package day04;

import java.util.*;

/**
 * 泛型
 * 泛型又称为参数化类型，是将当前类的属性的类型，方法参数的类型，以及方法返回值的类型的定义权交给使用者。
 * 使用者在创建当前类的同时将泛型的实际类型传入。
 * 当我们对泛型设置值时，会检查是否满足类型需求，当我们获取泛型值时，会自动进行类型转换。
 * 原型为Object
 * 
 * 集合支持泛型，泛型是用来约束集合中的元素类型
 * 
 * java.util.List
 * 可重复集，并且有序，可通过下标操作元素
 * 常用实现类：
 * ArrayList：使用数组实现，查询更快
 * LinkedList：使用链表实现，增删更快
 * 
 * E set(int index,E e)
 * 将给定元素设置到指定位置上
 * 返回值为原位置的元素，所以是替换操作，只能操作现有元素，不能用此方法新增元素
 * 
 * E get(int index)
 * 获取给定下下标的元素
 * 
 * void add(index i,E e)
 * 将指定元素插入到指定位置
 * 
 * E remove(int index)
 * 从集合中删除指定元素，并将其返回
 * 
 * List subList(int start,int end)
 * 获取当前集合中的指定范围内的子集，同样含头不含尾
 * 对子集的任何修改，相当于修改原集合的那部分内容
 * 
 * Object[] array=c.toArray(T[] a);
 * 将当前集合转换为数组可用，则使用给定数组，反之则会自动创建一个与给定数组同类型的数组
 * 若给定数组
 * 
 * 数组转换为集合
 * 转换只能转换List集合，使用的是数组工具类Arrays的静态方法asList
 * 只能转换List的原因是Set不能存放重复元素，可能会出现丢失元素的情况
 * 
 * 排序集合元素
 * 排序集合元素使用的是集合工具类Collections的静态方法sort
 * 排序仅对List进行，因为Set是无序的
 * @author planetarianZero
 */
public class GenericityDemo 
{
	public static void main(String[] args) 
	{
		//GenericityTest();
		//ListTest();
		//ListTest2();
		//ListTest3();
		//ListTest4();
		//ListTest5();
		SortTest();
	}
	
	public static void GenericityTest()
	{
		Collection<String> c=new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		//c.add(1);语法错误
		
		for(String str:c)
		{
			System.out.println(str);
		}
		Iterator<String> it=c.iterator();//迭代器只能在集合中存在元素时才可建立，否则会有异常
		while(it.hasNext())
		{
			String str=it.next();
			System.out.println(str);
		}
	}
	
	public static void ListTest()
	{
		List<String> l=new ArrayList<String>();
		l.add("one");
		l.add("two");
		l.add("three");
		l.add("four");
		System.out.println(l);
		String old=l.set(1, "2");
		System.out.println(l);
		System.out.println(old);
		String str=l.get(2);
		System.out.println(str);
		for(int i=0;i<l.size();i++)
		{
			str=l.get(i);
			System.out.println(str);
		}
	}
	public static void ListTest2()
	{
		List<String> l=new ArrayList<String>();
		l.add("one");
		l.add("two");
		l.add("three");
		l.add("four");
		l.add(1, "2");
		System.out.println(l);
		String old=l.remove(2);
		System.out.println(l);
		System.out.println(old);
	}
	public static void ListTest3()
	{
		List<Integer> l=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			l.add(i);
		}
		System.out.println(l);
		List<Integer> sub=l.subList(3, 8);
		System.out.println(sub);
		for(int i=0;i<sub.size();i++)
		{
			sub.set(i, sub.get(i)*10);
		}
		System.out.println(sub);
		System.out.println(l);
		l.subList(2, 9).clear();
		System.out.println(l);
	}
	public static void ListTest4()
	{
		Collection<String> c=new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		String[] array=c.toArray(new String[c.size()]);
		System.out.println(array.length);
		for(String str:array)
		{
			System.out.println(str);
		}
	}
	public static void ListTest5()
	{
		String[] array={"one","two","three","four"};
		List<String> list=Arrays.asList(array);
		List<String> list1=new ArrayList<String>();
		list1.addAll(list);
		list1.add("five");
		System.out.println(list1);
	}
	public static void SortTest()
	{
		List<Integer> l=new ArrayList<Integer>();
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			l.add(r.nextInt(100));
		}
		Collections.sort(l);
		System.out.println(l);
	}
}
