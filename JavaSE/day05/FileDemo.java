package day05;
import java.io.*;
/**
 * java.io.File
 * File中每一个实例都可以表示文件系统中的一个文件或目录
 * 使用File可以
 * 访问文件或目录的属性
 * 操作文件或目录
 * 访问目录中的所有内容
 * 但不可以访问文件数据
 * 
 * String getName()
 * 获取文件名
 * 
 * long length()
 * 返回文件大小（字节）
 * 
 * boolean isFile()
 * 判断是否为文件
 * 
 * boolean isDirectory()
 * 判断否为目录
 * 
 * boolean isHidden()
 * 判断是否为隐藏文件
 * 
 * boolean exists()
 * 判断文件是否存在
 * 
 * boolean delete()
 * 文件，空目录删除
 * 
 * boolean mkdirs()
 * 创建多级目录,能把不存在的父目录一起创建出来
 * 
 * File[] listFiles()
 * 返回一个目录下的所有子项
 * 
 * 获取一个目录中符合条件的部分子项
 * 使用重载的listFiles方法，需要传入一个文件过滤器参数，
 * 文件过滤器是一个接口：FileFilter
 * 
 * @author planetarianZero
 *
 */
public class FileDemo 
{
	public static void main(String args[])
	{
		//Demo();
		//Demo2();
		//Demo3();
		Demo4();
	}
	public static void Demo()
	{
		File file=new File("."+File.separator+"demo.txt");
		try 
		{
			file.createNewFile();
			System.out.println("Success");
		} catch (IOException e) 
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(file.exists())
		{
			file.delete();
			System.out.println("删除完毕");
		}
		else 
		{
			System.out.println("文件不存在");
		}
	}
	public static void Demo2()
	{
		File dir=new File("demo");
		File dirs=new File("a"+File.separator+"b");
		if(!dir.exists())
		{
			System.out.println("创建目录完毕");
		}
		else 
		{
			System.out.println("目录已存在");
		}
		if(!dirs.exists())
		{
			dirs.mkdirs();
			System.out.println("创建目录完毕");
		}
		else 
		{
			System.out.println("目录已存在");
		}
	}
	public static void Demo3()
	{
		File dir=new File(".");
		File[] files=dir.listFiles();
		for(File file:files)
		{
			if(file.isFile())
			{
				System.out.println("文件："+file.getName());
				
			}
			else 
			{
				System.out.println("目录："+file.getName());
			}
		}
	}
	
	public static void Demo4()
	{
		File file=new File(".");
		/*
		 * 获取名字以"."开头的子项
		 */
		File[] subs=file.listFiles(new FileFilter() 
		{
			public boolean accept(File file) 
			{
				return file.getName().startsWith(".");
			}
		});
		for(File sub:subs)
		{
			System.out.println(sub.getName());
		}
	}
	public static void delect(File file)
	{
		if(file.isDirectory())
		{
			File[] subs=file.listFiles();
			for(File sub:subs)
			{
				delect(sub);//递归
			}
		}
		file.delete();
	}
}
