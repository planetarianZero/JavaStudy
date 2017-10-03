package day08;

/**
 * java异常捕获机制中的try-catch块
 * try块是用来括上可能出错的代码块，catch块是用来捕获try块中代码抛出来的错误，并解决。
 * 
 * JVM在执行代码的过程中，若发现了一个异常，则会实例化这种情况的异常实例，并将代码整个执行过程完整设置到
 * 异常中来，表示该错误报告，设置完毕后将该异常抛出，若抛出异常的这句代码被try包围，则JVM会检查catch中
 * 是否关注该异常，关注则交给catch解决，否则抛出异常到方法外，由调用当前方法的代码解决该异常。
 * 
 * 当多个catch捕获不同异常时，这些异常间存在继承关系，那么子类异常要在上先行捕获，父类异常在下。
 * 
 * finally块
 * 定义在异常捕获机制的最后，可以直接跟在try块之后或者最后一个catch块之后。
 * 其中的代码一定会执行，无论try块中的代码是否抛出异常，所以通常会把资源释放操作放在finally中，比如
 * 关闭流。
 * 
 * 当一个方法中使用throw抛出一个异常时，就要在方法上面使用throws声明该类异常的抛出，以通知调用者解决。
 * 只有RuntimeException及其子类异常使用throw抛出时，不强制要求必须使用throws声明。其他异常都是强制要求的
 * 否则编译不通过。
 * 当调用一个含有throws声明异常抛出的方法时，编译器要求必须处理该异常，处理手段有两种：
 * 使用try—catch捕获并处理。
 * 在当前方法上继续使用throws声明该异常地抛出。
 * 
 * 重写父类一个含有throws异常抛出声明的方法时，子类该方法throws重写原则
 * 允许：
 * 不再抛出任何异常
 * 仅抛出父类方法中抛出的部分异常
 * 抛出父类方法抛出异常的子类型异常
 * 不允许：
 * 抛出额外异常
 * 抛出父类方法抛出异常的父类型异常
 * 
 * 自定义异常，通常是用来描述某个业务逻辑上出现的问题，一般情况下都要继承自Exception，
 * 自定义异常的名字应做到见名知意。
 * 
 * @author 87188
 *
 */
public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
	}

}

class IllegalAgeException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalAgeException() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public IllegalAgeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO 自动生成的构造函数存根
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO 自动生成的构造函数存根
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO 自动生成的构造函数存根
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO 自动生成的构造函数存根
	}
	
}
