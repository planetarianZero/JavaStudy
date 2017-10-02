package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 文件输入输出流
 * 
 * 流根据方向不同分为输入流和输出流，参照点为当前程序，输入流为读取数据，输出流用来写数据
 * 
 * java.io.InputStream
 * 抽象类，定义了输入流的读取字节方法，所有的字节输入流都继承于它
 * 
 * java.io.OutputStream
 * 抽象类，是所有字节输出流的父类
 * 
 * 流分节点流和处理流
 * 节点流：又称低级流，是真实负责读写数据的流，读写数据中必须要有低级流，数据源明确
 * 
 * 处理流：又称高级流，读写可以没有高级流，高级流不能独立存在，必须用于处理其他流，处理其他流的目的是
 * 简化读写数据中的操作。
 * 
 * java.io.FileOutputStream
 * 文件输出流，是一个低级流，作用是向文件中写出字节。
 * 
 * java.io.BufferedInputStream
 * java.io.BufferedOutputStream
 * 缓冲字节输入输出流是一对高级流，使用它们可以加快读写效率
 * 
 * 高级流可以处理其他流，但无论添加了多少高级流，最底下都要有低级流，因为低级流是真实读写数据的流，
 * 高级流都是处理数据的。高级流处理其他流形成流的链接，并且有效的组合不同的高级流可以得到叠加的效果。
 * 
 * 关闭时只需关闭最外层的高级流
 * 
 * 缓冲流内部有一个缓冲区，当read方法读取第一个字节时，实际上BIS会读取一组字节并存入内部的字节数组中，
 * 然后将第一个字节返回，当再次调用read方法时，直接从字节数组中第二个字节返回。直到字节数组中所有字节
 * 全部返回后，才会再次读取一组字节。所以缓冲流也是提高一次读写的数据量，减少读写次数来提高读写效率的。
 * 
 * void flush()
 * 强制将缓冲区的字节一次性写出
 * 
 * 对象流是一对高级流，作用是方便读写Java中的对象。
 * java.io.ObjectOutputStream
 * 对象输出流，可以将给定的对象转化为一组字节后写出。
 * 
 * void writeObject(Object)
 * 写出一个Object类型的对象，当一个类想被对象流读写，必须实现java.io.Serializable接口
 * 它是一个签名接口，即接口中没有规定任何的抽象方法或变量
 * 
 * java.io.ObjectInputStream
 * 对象输入流，作用是可以将对象反序列化，读取一组字节并还原为对象。
 * OIS读取的字节必须是由OOS将对象序列化得到的字节，否则会抛出异常。
 * 
 * transient关键字用来修饰属性，当一个属性被此关键字修饰时，该类实例在使用OOS进行对象序列化时，
 * 该属性值会被忽略，从而达到“瘦身”的目的。
 * 
 * 当一个类实现了Serializable接口，应当添加一个常量serialVersionUID，该常量为当前类的序列话版本号，
 * 若不定义，系统会根据当前类的结构生成，但是只要类的结构发生改变，序列号也会相应发生改变。
 * 版本号影响着反序列化的结果，当OIS对一个对象进行反序列化时，对象与该类的版本是否一致，
 * 若一致：反序列化成功，但是若该对象与类的结构不一样时，则采用兼容模式，能还原的属性都还原。
 * 不一致：反序列话直接抛出版本不一致异常。
 * 
 * @author 87188
 *
 */
public class FileStreamDemo 
{
	public static void main(String[] args) throws IOException 
	{
		//Demo();
		//Demo2();
		//Copy("fos.txt");
		//CopyDemo3();
		//Demo4();
		//Demo5();
		Demo6();
	}
	public static void Demo() throws IOException
	{
		//默认创建的FOS是覆盖写操作，FOS会先将文件数据全部删除，然后再开始写入。
		//在创建FOS时，若指定第二个参数，并且该值为true时，则是追加写操作，那么本次通过FOS追加写出的
		//内容将会写到文件末尾
		FileOutputStream fos=new FileOutputStream("fos.txt",true);
		String text="Hello World";
		fos.write(text.getBytes("UTF-8"));
		System.out.println("Success");
		fos.close();
	}
	public static void Demo2() throws IOException
	{
		FileInputStream fis=new FileInputStream("fos.txt");
		byte[] data=new byte[100];
		int len=fis.read(data);
		String str=new String(data,0,len,"UTF-8");
		System.out.println(str);
		fis.close();
	}
	public static void Copy(String fileName)
	{
		byte[] data=new byte[100];
		int len=-1;
		try 
		{
			FileInputStream fis=new FileInputStream(fileName);
			FileOutputStream fos=new FileOutputStream("copy_"+fileName);
			try 
			{
				fis.read(data);
				while((len=fis.read(data))!=-1)
				{
					fos.write(data,0,len);
				}
				System.out.println("Success");
				fos.close();
				fis.close();
			} catch (IOException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static void CopyDemo3(String fileName)
	{
		int len=-1;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			FileOutputStream fos=new FileOutputStream("copy_"+fileName);
			BufferedInputStream bis=new BufferedInputStream(fis);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			try{
				while((len=bis.read())!=-1)
				{
					bos.write(len);
				}
				System.out.println("Success");
				bis.close();
				bos.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void Demo4()
	{
		try {
			FileOutputStream fos=new FileOutputStream("test.txt");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			bos.write("1234".getBytes("UTF-8"));
			bos.flush();
			System.out.println("Success");
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Demo5()
	{
		try {
			FileOutputStream fos=new FileOutputStream("test.obj");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			//ObjectOutStream的WriteObject方法可以将给定的对象转换为一组字节后写出，
			//这些字节比该对象的实际内容要大，因为除了数据之外还有结构描述等信息。
			/*
			 * 下面的代码实际上经历了两个操作：
			 * 1.将String对象转化成一组字节，将一个对象转化成一组字节的过程称之为：对象序列化
			 * 2.再通过fos将这组字节写入到硬盘中，将该对象写入到硬盘并长久保存的过程称之为：对象持久化
			 */
			oos.writeObject("qwerasd");
			System.out.println("Success");
			oos.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void Demo6()
	{
		try {
			FileInputStream fis=new FileInputStream("test.obj");
			ObjectInputStream ois=new ObjectInputStream(fis);
			try {
				String s=(String)ois.readObject();
				System.out.println(s);
				System.out.println("Success");
				ois.close();
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
