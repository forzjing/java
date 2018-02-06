package javaSe;

import java.util.Date;

public class Thread_State_join_yield_daemon_priority {

	public static void main(String[] args) {
		// 线程安全的类
		/*
		 * StringBuffer sb=new StringBuffer(); Vector<String> v= new
		 * Vector<String>(); Hashtable<String, String> h=new
		 * Hashtable<String,String>(); List<String>
		 * list=Collections.synchronizedList(new ArrayList<String>());
		 */
		/*
		 * public final void stop():让线程停止，过时了，但是还可以使用。
		 * public void interrupt():中断线程。 把线程的状态终止，并抛出一个InterruptedException。
		 /*
		/*ThreadStop ts = new ThreadStop();
		ts.start();
		try {
			Thread.sleep(3000);
			ts.interrupt();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}*/
		
		/*
		 * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
		 * 当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。 
		 */
	/*	ThreadDaemon td1 = new ThreadDaemon();
		ThreadDaemon td2 = new ThreadDaemon();
		td1.setDaemon(true);
		td2.setDaemon(true);
		td1.setName("关羽");
		td2.setName("张飞");

		td1.start();
		td2.start();
		Thread.currentThread().setName("刘备");
		for (int x = 0; x < 10; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}*/
		
		/*
		 * public final void join():等待该线程终止。 
		 */
		/*ThreadJoin tj1 = new ThreadJoin();
		ThreadJoin tj2 = new ThreadJoin();
		ThreadJoin tj3 = new ThreadJoin();

		tj1.setName("李渊");
		tj2.setName("李世民");
		tj3.setName("李元霸");
		
		tj1.start();
		try {
			tj1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		tj2.start();
		tj3.start();*/
		
		//线程默认优先级是5。
		// 线程优先级的范围是：1-10。
		 //线程优先级高仅仅表示线程获取的 CPU时间片的几率高，但是要在次数比较多，或者多次运行的时候才能看到比较好的效果。
		/*ThreadPriority tp1 = new ThreadPriority();
		ThreadPriority tp2 = new ThreadPriority();
		ThreadPriority tp3 = new ThreadPriority();

		tp1.setName("东方不败");
		tp2.setName("岳不群");
		tp3.setName("林平之");
		tp1.setPriority(10);
		tp2.setPriority(1);

		tp1.start();
		tp2.start();
		tp3.start();*/
		
		/*ThreadSleep ts1 = new ThreadSleep();
		ThreadSleep ts2 = new ThreadSleep();
		ThreadSleep ts3 = new ThreadSleep();

		ts1.setName("林青霞");
		ts2.setName("林志玲");
		ts3.setName("林志颖");

		ts1.start();
		ts2.start();
		ts3.start();*/
	}

}

class ThreadSleep extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(getName() + ":" + x + ",日期：" + new Date());
			// 睡眠
			// 困了，我稍微休息1秒钟
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadPriority extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(getName() + ":" + x);
		}
	}
}


class ThreadJoin extends Thread{
	public void run() {
		for(int x=0;x<10;x++) {
			System.out.println(getName()+":"+x);
		}
	}
}

class ThreadYield extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(getName() + ":" + x);
			Thread.yield();
			/*
			 * public static void yield():暂停当前正在执行的线程对象，并执行其他线程。 
			 * 让多个线程的执行更和谐，但是不能靠它保证一人一次。
			 */
		}
	}
}

class ThreadDaemon extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println(getName() + "::::::::::::" + x);
		}
		/*
		 * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
		 * 当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。 
		 */
	}
}
class ThreadStop extends Thread {
	@Override
	public void run() {
		System.out.println("开始执行：" + new Date());

		// 我要休息10秒钟，亲，不要打扰我哦
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println("线程被终止了");
		}

		System.out.println("结束执行：" + new Date());
	}
}