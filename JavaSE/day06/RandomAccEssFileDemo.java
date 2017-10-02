package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAeecssFile
 * 用来读写文件数据
 * 是基于指针进行读写的，它总是在指针指向的位置读写字节，并且读写后，指针自动后移
 * 既可以读数据，也可以写数据
 * 
 * 该类的构造函数提供两种模式，分别为String,String和File,String
 * 其中第二个参数为选择操作模式，分别有r：只读；rw：读写
 * 
 * 该类还提供了方便的读写基本类型数据的方法
 * 
 * void write(int d)
 * 写出给定的int值对应的二进制的低八位
 * 再次调用会重新从文件开头写，就是会抹掉以前的数据
 * d应为ASCII值
 * 
 * int read()
 * 读取一个字节，并以十进制的int值返回
 * 若显示-1，则读到文件末尾，但是不可能读到-1，即使文件中有-1
 * 
 * int read(byte[] data)
 * 一次性尝试读取给定的数组长度的字节量，并存入该数组中，返回值为实际读取到的字节数量，
 * 若返回-1，则表示读到文件末尾
 * 
 * int write(byte[] date)
 * 一次性将给定数组中的所有字节写出
 * 
 * int write(byte[] data,int start,int len)
 * 将给定数组中，从start开始的len个字节一次性写出
 * 
 * long getFilePointer()
 * 获取当前RAF的指针位置 
 * 
 * void seek(long pos)
 * 移动指针到指定位置
 * 
 * @author 87188
 *
 */
public class RandomAccEssFileDemo 
{
	public static void main(String[] args)
	{
		//Demo();
		//Demo2();
		//Copy();
		//Deom3();
		Demo4();
	}
	public static void Demo()
	{
		try 
		{
			RandomAccessFile raf=new RandomAccessFile("."+File.separator+"files.dat", "rw");
			try 
			{
				raf.write(10);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void Demo2()
	{
		try 
		{
			RandomAccessFile raf=new RandomAccessFile("."+File.separator+"files.dat", "r");
			try 
			{
				int value=raf.read();
				System.out.println(value);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void Copy()
	{
		int len = -1;
		byte[] buf=new byte[1024*10];
		try 
		{
			RandomAccessFile src=new RandomAccessFile("."+File.separator+"files.dat", "r");
			RandomAccessFile copy=new RandomAccessFile("."+File.separator+"files_cp.dat", "rw");
			try 
			{
				long start=System.currentTimeMillis();
				while((len=src.read(buf))!=-1)
				{
					copy.write(buf,0,len);
				}
				long end=System.currentTimeMillis();
				System.out.println("复制完成，耗时："+(end-start));
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void Deom3()
	{
		int max=Integer.MAX_VALUE;
		try 
		{
			RandomAccessFile raf=new RandomAccessFile("raf1", "rw");
			try 
			{
				raf.writeInt(max);
				raf.writeDouble(132.213);
				raf.writeLong(1234L);
				
				System.out.println("当前指针的位置："+raf.getFilePointer());
				
				raf.seek(0);
				raf.readInt();
				
				raf.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void Demo4()
	{
		
	}
	public String readString(int len,RandomAccessFile raf) throws IOException
	{
		byte[] data=new byte[len];
		raf.read(data);
		return new String(data,"UTF-8").trim();
	}
}
