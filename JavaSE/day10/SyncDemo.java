package day10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 多线程并发访问同一资源时，就会形成“抢”的现象，由于线程切换时机不确定，可能导致执行代码顺序混乱，
 * 严重时会导致系统瘫痪。
 * 
 * 当一个方法被synchronized修饰后，该方法为同步方法，即：多个线程不能同时计入该方法内部执行。
 * 对于成员方法而言，synchronized会在一个线程调用该方法时将该方法所属对象加锁，
 * 其他线程在执行该方法时，由于执行该方法的线程没有释放锁，所以只能在方法外阻塞，直到持有方法锁的线程将
 * 方法执行完毕，所以，解决多线程并发执行安全问题的办法就是把“抢”变成“排队”。
 * 
 * 同步块
 * 有效的缩小同步范围可以在保证并发安全的同时，尽可能提高并发效率。
 * 同步块可以要求多个线程对该块内的代码排队执行，但前提条件是同步监视器对象（即上锁的对象）要求多个线程
 * 看到的必须是同一个。
 * 语法：
 * synchronized(同步监视器对象)
 * {
 * 		需要同步的代码块
 * }
 * 所谓同步执行即：多个线程必须排队执行
 * 所谓异步执行即：多个线程可以同时执行
 * 
 * 静态方法的同步
 * 当一个静态方法被synchronized修饰时，那么该方法即为同步方法，由于静态方法从属类，全局就一份，所以同步
 * 的静态方法一定具有同步效果，与对象无关。
 * 
 * 互斥锁
 * synchronized也叫互斥锁，即：使用synchronized修饰多段代码，只要它们的同步监视器对象相同，那么这几段
 * 代码间就是互斥关系，即：多个线程不能同时执行这些代码。
 * 
 * 就算是线程安全的集合，那么其中对于元素的操作，如add，put等方法都不予迭代器遍历做互斥，需要自行维护
 * 互斥关系。
 * 
 * 线程池
 * 线程池主要有两个作用
 * 1、重用线程
 * 2、控制线程数量
 * 当我们的应用需要创建大量线程或者发现线程会频繁的创建和销毁时就应当考虑使用线程池来维护线程。
 * 
 * @author 87188
 *
 */
public class SyncDemo 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Demo();
		//Demo1();
		//Demo2();
		//Demo3();
		//Demo4();
		Demo5();
	}
	
	public static void Demo()
	{
		Table table=new Table();
		Thread t1=new Thread()
		{
			public void run()
			{
				while(true)
				{
					int bean=table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
				while(true)
				{
					int bean=table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}

	public static void Demo1()
	{
		Shop shop=new Shop();
		Thread t1=new Thread()
		{
			public void run()
			{
				shop.buy();
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
	
	public static void Demo2()
	{
		Thread t1=new Thread()
		{
			public void run()
			{
				Foo.dosome();
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
				Foo.dosome();
			}
		};
		
		t1.start();
		t2.start();
	}

	public static void Demo3()
	{
		Boo b=new Boo();
		Thread t1=new Thread()
		{
			public void run()
			{
				b.methodA();
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
				b.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}

	public static void Demo4()//把集合转换为线程安全的
	{
		/*
		 * ArrayList与LinkedList都不是线程安全的
		 */
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list=Collections.synchronizedList(list);//把list转化为线程安全的
		System.out.println(list);
		
		Set<String> set=new HashSet<String>(list);
		set=Collections.synchronizedSet(set);//把set转换为线程安全的
		System.out.println(set);
		
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "1");
		map.put(2, "2");
		map=Collections.synchronizedMap(map);//把map转换为线程安全的
		System.out.println(map);
	}

	public static void Demo5()//线程池的使用
	{
		ExecutorService threadPool=Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++)
		{
			Runnable runn=new Runnable() 
			{
				public void run() 
				{
					Thread th=Thread.currentThread();
					try {
						System.out.println(th.getName()+"正在运行");
						Thread.sleep(5000);
						System.out.println(th.getName()+"执行完毕");
					} catch (Exception e) {
						System.out.println("线程被中断");
					}
				}
			};
			threadPool.execute(runn);
			System.out.println("指派了一个任务交给线程池");
		}
		threadPool.shutdownNow();
		System.out.println("线程池停止了");
	}
}
class Table //synchronized使用方法一
{
	private int bean=20;
	
	public synchronized int getBean()
	{
		if(bean==0)
		{
			throw new RuntimeException("没有了！");
		}
		Thread.yield();//切换到另一个线程
		return bean--;
	}
}

class Shop //synchronized使用方法二
{
	public void buy()
	{
		Thread t=Thread.currentThread();
		
		try
		{
			System.out.println(t.getName()+"正在挑衣服。。。");
			Thread.sleep(5000);
			
			synchronized (this) 
			{
				System.out.println(t.getName()+"正在试衣服。。。");
				Thread.sleep(5000);
			}
			
			System.out.println(t.getName()+"离开");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class Foo //synchronized使用方法三
{
	public synchronized static void dosome()
	{
		try 
		{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+"正在执行");
			Thread.sleep(5000);
			System.out.println(t.getName()+"执行完毕");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

class Boo
{
	public synchronized void methodA()
	{
		try 
		{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+"方法A正在执行");
			Thread.sleep(5000);
			System.out.println(t.getName()+"方法A执行完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB()
	{
		try 
		{
			Thread t=Thread.currentThread();
			System.out.println(t.getName()+"方法B正在执行");
			Thread.sleep(5000);
			System.out.println(t.getName()+"方法B执行完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
