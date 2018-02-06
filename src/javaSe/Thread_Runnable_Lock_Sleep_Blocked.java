package javaSe;
/*
 * 进程:就是正在运行的程序,是系统进行资源分配和调用的独立单位,
 * 每个进程都有自己的内存空间和系统资源,可以同时执行多个任务,提高cpu使用
 * 线程:是程序的执行路径,是使用cpu的基本单位,可以提高应用程序的使用率
 * 线程的执行有随机性,更多的线程可以提高获取cpu执行权的几率.
 * IllegalThreadStateException 非法的线程状态
 * 并行是同时运行,平行, 并发是同时开启,爆发
 * jvm是多线程的.
 * 是否是多线程环境
 * 是否有数据共享
 * 是否是多条语句操作共享数据
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockRunnable implements Runnable { 
	boolean b;
	public LockRunnable() {
	}
	public LockRunnable(boolean b) {
		this.b = b;
	}
	@Override
	public void run() {
		if (b) {
			synchronized (LockRunnable.class) {
				System.out.println("I'm in LockRunnable I'm waiting LockThread unlock");
				synchronized (LockThread.class) {
					System.out.println("I'm in LockThread LockThread Locked");
				}
			}
		} else {
			synchronized (LockThread.class) {
				System.out.println("I'm in LockThread LockThread Locked");
				synchronized (LockRunnable.class) {
					System.out.println("I'm in LockRunnable LockRunnable Locked");
				}
			}
		}
	}
}
class LockThread extends Thread {
	boolean b;
	public LockThread() {
	}
	public LockThread(boolean b) {
		this.b = b;
	}
	@Override
	public void run() {
		if (b) {
			synchronized (LockThread.class) {
				System.out.println("I'm waiting LockRunnable unlock");
				synchronized (LockRunnable.class) {
					System.out.println("I'm in LockRunnable LockRunnable Locked");
				}
			}
		} else {
			synchronized (LockRunnable.class) {
				System.out.println("I'm in LockRunnable I'm waiting LockThread unlock");
				synchronized (LockThread.class) {
					System.out.println("I'm in LockThread LockThread Locked");
				}
			}
		}
	}
}

public class Thread_Runnable_Lock_Sleep_Blocked {

	public static void main(String[] args) {
		// DeadLock Thread
		// 继承Thread Thread DeadLock
		// 重写run();
		// 创建new对象;
		// 对象.start();
		/*LockThread lt2 = new LockThread(true);
		LockThread lt1 = new LockThread(false);
		lt2.start();
		lt1.start();
		System.out.println(Thread.currentThread().getName() + "locking...");*/
		
		//ThreadWaiting -sleep -ReentrantLock
		LockWait lw=new LockWait();
		Thread th1=new Thread(lw);
		Thread th2=new Thread(lw); 
		th1.start(); th2.start();

		// DeadLock Runnable
		// 实现Runnable Runnable DeadLock
		// 重写run();
		// 创建新对象;
		// 传给Thread()构造
		// thread对象.start(); 
		 /*LockRunnable lock1=new LockRunnable(true); 
		 LockRunnable lock2=new LockRunnable(false); 
		 Thread t1=new Thread(lock1);
		 Thread t2=new Thread(lock2); 
		 t1.start(); t2.start();*/
		//System.out.println(Thread.currentThread().getName()+"---------");
	}
}

// 实现两个线程同时打印数字和字符?
class LockWait implements Runnable {
	private static int total = 5;
	private Lock lock = new ReentrantLock();
	private static String result = "abcdefghij";

	@Override
	public void run() {
		while (total > 0) {
			try {
				lock.lock();
				Thread.sleep(1000);  //不释放锁
				lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + (total--));
		}
	}
}