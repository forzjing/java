package javaSe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_Try_Catch_syn_888888_Lock {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		Thread th2 = new Thread(thread2);
		Thread th1 = new Thread(thread1);
		th2.start();
		th1.start();
//???
		MyLock a = new MyLock();
		//MyLock b = new MyLock();
		Thread x = new Thread(a);
		Thread y = new Thread(a);
		x.start();
		y.start();
	}

}

class MyThread implements Runnable {
	int ticket = 4;

	@Override
	public void run() {
		synchronized (MyThread.class) { // synchronized 同步 Lock 同步
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "\t" + ticket--);
			}
		}
	}
}
//????
class MyLock implements Runnable {
	int total = 4;
	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		
		try {lock.lock();
			Thread.sleep(3000);lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (total > 0) {
			System.out.println(Thread.currentThread().getName() + "\t" + total--);
		}
		
	}
}