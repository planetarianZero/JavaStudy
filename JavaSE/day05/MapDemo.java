package day05;
import java.util.Map.Entry;
import java.util.*;
/**
 * java.util.Map
 * map看起来象是一个多行两列的表格，以键值对的形式存放元素，map中key不允许重复
 * 常用实现类为HashMap
 * @author planetarianZero
 * V push(K k,V v)
 * 将指定的键值对存入Map
 * 由于key不允许重复，若使用Map已有的key存入一个新的value，则为替换操作，返回值为原value值，否则返回null
 * 
 * V get(K k)
 * 根据key获取指定的value
 * 
 * V remove(K k)
 * 从Map中删除给定的key所对应的键值对，返回键值对中的value
 * 
 * 遍历Map
 * 遍历Map有三种方式，遍历所有Key，遍历所有键值对，遍历所有value（相对不常用）
 * 
 * 遍历所有的key
 * Set<K> keySet()
 * 该方法会将当前map中所有key存入一个Set集合中返回，
 * 遍历该集合就等于遍历了所有的key
 * 
 * 遍历每一组键值对
 * Map中每一组键值对都是由Map的内部类
 * java.util.Map.Entry
 * 的一个实例表示的。
 * 
 * Set<Entry> entrySet()
 * 会将Map中的每一组键值对存入一个Set集合后返回
 * 
 * Collection values()
 * 会将当前Map中所有value装入collection中返回
 * 
 * 当一个类的实例作为HashMap时，他的equals方法和hashcode方法的重写直接影响着散列表的查询性能
 * 两个方法重写应当遵循
 * 一致性
 * 两个对象equals比较为true时，hashcode方法返回的数字必须相等。
 * 稳定性
 * hashcode方法多次调用后返回的数字应当相等，不应为一个变化的值，除非参与equals比较的属性值发生了改变
 */
public class MapDemo 
{
	public static void main(String[] args) 
	{
		//Demo();
		//Demo2();
		Demo3();
	}
	public static void Demo()
	{
		Map<String, Integer> map=BuildMap();
		Integer value=map.put("物理", 95);//此处引发自动拆箱，用引用类型接收数据
		System.out.println(map);
		System.out.println(value);
		value=map.get("语文");
		System.out.println("语文:"+value);
		value=map.get("生物");
		System.out.println("生物:"+value);
		value=map.remove("数学");
		System.out.println("删除数学:"+value);
	}
	public static void Demo2()
	{
		Map<String, Integer> map=BuildMap();
		//遍历键
		Set<String> key=map.keySet();
		for(String str:key)
		{
			System.out.println(str);
		}
		Set<Entry<String,Integer>> entrySet=map.entrySet();
		//遍历键值对
		for(Entry<String,Integer> e:entrySet)
		{
			String str=e.getKey();
			Integer value=e.getValue();
			System.out.println(str+":"+value);
		}
		//遍历值
		Collection<Integer> values=map.values();
		for(Integer value:values)
		{
			System.out.println(value);
		}
	}
	public static void Demo3()
	{
		
	}
	public static Map<String, Integer> BuildMap()
	{
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("语文", 98);
		map.put("数学", 92);
		map.put("英语", 93);
		map.put("政治", 94);
		map.put("地理", 95);
		System.out.println(map);
		return map;
	}
}
