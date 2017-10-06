package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 第一种创建线程的方式
 * 继承Thread并重写run()方法来定义线程要执行的任务。但该方式有两个不足：
 * 由于Java是单继承，那么当继承了Thread就无法再继承其他类。
 * 由于继承Thread后重写run方法规定了线程执行的任务，这导致线程与任务有一个必然的耦合关系，
 * 不利于线程的重用。
 * 
 * 第二种创建线程的方式
 * 实现Runnable接口并重写run方法
 * 
 * static Thread currentThread()
 * 获取运行当前方法的线程
 * 输出的结构为：线程名，优先级，线程组名
 * 
 * Thread getId()
 * 获取线程ID
 * 
 * String getName()
 * 获取线程名
 * 
 * int getPriority()
 * 获取优先级
 * 
 * boolean isAlive()
 * 判断是否存活
 * 
 * boolean isDaemon()
 * 是否为守护线程
 * 
 * boolean isInterrupted()
 * 是否被中断
 * 
 * 线程优先级
 * 线程的时间片分配完全听线程调度，线程只能被动的被分配时间，对于线程的调度工作不能干预。但是可以通过提高
 * 线程的优先级来达到尽可能干预的目的。
 * 理论上，优先级越高的线程，获取CPU时间片的次数就越多。
 * 
 * static void sleep(long ms)
 * 线程提供静态方法sleep可以使运行刚方法的线程进入阻塞状态指定毫秒，超时后线程会自动回到runnable状态
 * 
 * 守护线程，又称为后台线程
 * 当一个进程中所有的前台进程都结束时，进程就要结束，若还有后台线程运行，后台线程会被强制结束。
 * 
 * void setDaemon(boolean bool)
 * 必须在start方法前设置守护线程，main线程属于前台线程，main没有结束，其他后台进程也不会结束。
 * 
 * void join()
 * join方法可以使调用该方法的线程进入阻塞状态，直到该方法所属线程完成工作才会解除调用该方法
 * 线程的阻塞状态。join方法一般用来完成多个线程之间的同步工作问题。
 * 
 * @author 87188
 *
 */
public class ThreadDemo 
{
	
	/**
	 * @param args
	 */
	
	public static boolean isFinish=false;
	public static void main(String[] args) 
	{
		//Demo();
		//Demo1();
		//Demo2();
		//Demo3();
		//Demo4();
		//Demo5();
		//Demo6();
		//Demo7();
		//Demo8();
		Demo9();
	}
	
	public static void Demo()
	{
		ThreadDemo1 d1=new ThreadDemo1();
		ThreadDemo2 d2=new ThreadDemo2();
		/*
		 * 启动线程要指定start方法，而不是调用run方法，run方法是线程要执行的任务，
		 * 当线程的start方法被调用时，线程进入runnable状态，一旦获取cpu时间，run方法会自动被调用。
		 */
		d1.start();
		d2.start();
	}
	
	public static void Demo1()
	{
		MyRunnable1 r1=new MyRunnable1();
		MyRunnable2 r2=new MyRunnable2();
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		
		t1.start();
		t2.start();
	}
	
	//使用匿名内部类的方式创建线程（方式一）
	public static void Demo2()
	{
		Thread t1=new Thread()
		{
			public void run()
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("what are you doing?");
				}
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("I'm writting");
				}
			}
		};
		t1.start();
		t2.start();
	}
	
	//使用匿名内部类的方式创建线程（方式二）
	public static void Demo3()
	{
		Runnable runn1=new Runnable() 
		{
			public void run() 
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("what are yu doing now?");
				}
			}
		};
		Runnable runn2=new Runnable() 
		{
			public void run() 
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("I'm doing something");
				}
				
			}
		};
		Thread t1=new Thread(runn1);
		Thread t2=new Thread(runn2);
		
		t1.start();
		t2.start();
	}
	
	public static void Demo4()
	{
		Thread t=Thread.currentThread();
		System.out.println("运行main方法的线程是："+t);
		
		Thread t2=new Thread()
		{
			public void run()
			{
				Thread t=Thread.currentThread();
				System.out.println("运行匿名内部类中的方法的线程是："+t);
			}
		};
		t2.start();
	}
	
	public static void Demo5()
	{
		Thread main=Thread.currentThread();
		long id=main.getId();
		System.out.println(id);
		
		String name=main.getName();
		System.out.println(name);
		
		int priority=main.getPriority();
		System.out.println(priority);
		
		boolean alive=main.isAlive();
		System.out.println(alive);
		
		boolean deamon=main.isDaemon();
		System.out.println(deamon);
		
		boolean interrupted=main.isInterrupted();
		System.out.println(interrupted);
	}
	
	public static void Demo6()
	{
		Thread min=new Thread()
		{
			public void run()
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("min");
				}
			}
		};
		
		Thread normal=new Thread()
		{
			public void run()
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("normal");
				}
			}
		};
		
		Thread max=new Thread()
		{
			public void run()
			{
				for(int i=0;i<1000;i++)
				{
					System.out.println("max");
				}
			}
		};
		
		min.setPriority(Thread.MIN_PRIORITY);
		normal.setPriority(Thread.NORM_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		
		min.start();
		normal.start();
		max.start();
	}
	
	public static void Demo7()//电子表
	{
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		while(true)
		{
			String data=sdf.format(new Date());
			System.out.println(data);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public static void Demo8()
	{
		Thread t1=new Thread()
		{
			public void run()
			{
				for(int i=0;i<5;i++)
				{
					System.out.println("前台线程");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
				while(true)
				{
					System.out.println("后台线程");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		};
		
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
	}

	public static void Demo9()
	{
		Thread th=new Thread()
		{
			public void run()
			{
				System.out.println("开始下载");
				for(int i=0;i<100;i++)
				{
					System.out.println("down"+i+"%");
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				System.out.println("图片下载完毕");
				isFinish=true;
			}
		};
		
		Thread show=new Thread()
		{
			public void run()
			{
				System.out.println("开始显示图片");
				try {
					th.join();//等待th将图片下载完成
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if(!isFinish)
				{
					throw new RuntimeException("图片未加载");
				}
				System.out.println("图片显示完毕");
			}
		};
		th.start();
		show.start();
	}
	
}
class ThreadDemo1 extends Thread
{
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("what are you doing?");
		}
	}
}

class ThreadDemo2 extends Thread
{
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("I'm writting");
		}
	}
}

class MyRunnable1 implements Runnable
{
	@Override
	public void run() 
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("what are yu doing now?");
		}
		// TODO 自动生成的方法存根
		
	}
}

class MyRunnable2 implements Runnable
{
	@Override
	public void run() 
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println("I'm doing something");
		}
		// TODO 自动生成的方法存根
		
	}
}
