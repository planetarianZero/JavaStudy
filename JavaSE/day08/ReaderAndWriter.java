package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 字符转换流
 * 字符流的读写单位为字符，字符流都是高级流，虽然以字符为单位读写数据，但实际底层还是读写字节，
 * 只是从字节与字符的转换工作交给了字符流来完成。
 * java.io.Reader:字符输入流的顶级父类
 * java.io.Writer:字符输出流的顶级父类
 * 
 * 大多数字符流只能处理其他字符流，而低级流又是字节流，这就导致字符流不能处理字节流的问题，转换流相当于
 * 是一个转换器的作用，它们可以将字节流先转变为字符流，这样其他的字符流就可以处理了。
 * 
 * 缓冲字符流
 * BufferedWriter，BufferedReader
 * 特点是可以按行读写字符串。
 * BufferedReader：缓冲字符输入流，特点是按行读取字符串。
 * 
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流，创建该对象时，其内部一定会创建BufferedWriter作为缓冲功能的叠加。
 * 提供了多种构造方法，其中有两个可以直接对文件进行写出操作的构造方法。
 * String readLin()
 * 连续读取若干字符，读到换行符为止，但返回的字符串不包含换行符。读到文件末尾返回null。
 * 
 * PrintWriter(File file)
 * PrintWriter(String path)
 * 
 * PrinterWriter也提供了可以处理其他流的构造方法，提供的方法可以传入字节流，也可以处理字符流，并且当使用
 * 这类构造方法时，可以再传入第二个参数，该参数为Boolean值，当该值为true时，则具有了自动行刷新功能。
 * 只有调用println方法时，才能实现自动行刷新。即flush()方法。
 * 
 * @author 87188
 *
 */
public class ReaderAndWriter 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Demo();
		//Demo2();
		//Demo3();
		//Demo4();
		Demo5();
	}
	
	public static void Demo()
	{
		try {
			FileOutputStream fos = new FileOutputStream("osw.txt");
			//OutputStreamWriter osw=new OutputStreamWriter(fos);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			try {
				osw.write("123456");
				osw.write("asdfgh");
				System.out.println("Success");
				osw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void Demo2()
	{
		int d=-1;
		try {
			FileInputStream fis=new FileInputStream("osw.txt");
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			while((d=isr.read())!=-1)
			{
				System.out.print((char)d);
			}
			isr.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void Demo3()
	{
		try {
			FileOutputStream fos=new FileOutputStream("pw1.txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			PrintWriter pw=new PrintWriter(osw);
			pw.println("12345");
			pw.println("asdfg");
			System.out.println("Success");
			pw.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void Demo4()
	{
		String fileName;
		String text=null;
		Scanner sc=new Scanner(System.in);
		fileName=sc.next();
		try
		{
			FileOutputStream fos=new FileOutputStream(fileName+".txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			PrintWriter pw=new PrintWriter(osw,true);
			while(true)
			{
				text=sc.nextLine();
				if(text.equals("exit"))
				{	
					break;
				}
				pw.println(text);
			}
			System.out.println("Fin");
			pw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void Demo5()
	{
		String line=null;
		try 
		{
			FileInputStream fis=new FileInputStream("src/day08/ReaderAndWriter.java");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			while((line=br.readLine())!=null)
			{
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
