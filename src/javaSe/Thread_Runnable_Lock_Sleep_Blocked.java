package javaSe;
/*
 * ����:�����������еĳ���,��ϵͳ������Դ����͵��õĶ�����λ,
 * ÿ�����̶����Լ����ڴ�ռ��ϵͳ��Դ,����ͬʱִ�ж������,���cpuʹ��
 * �߳�:�ǳ����ִ��·��,��ʹ��cpu�Ļ�����λ,�������Ӧ�ó����ʹ����
 * �̵߳�ִ���������,������߳̿�����߻�ȡcpuִ��Ȩ�ļ���.
 * IllegalThreadStateException �Ƿ����߳�״̬
 * ������ͬʱ����,ƽ��, ������ͬʱ����,����
 * jvm�Ƕ��̵߳�.
 * �Ƿ��Ƕ��̻߳���
 * �Ƿ������ݹ���
 * �Ƿ��Ƕ�����������������
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
		// �̳�Thread Thread DeadLock
		// ��дrun();
		// ����new����;
		// ����.start();
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
		// ʵ��Runnable Runnable DeadLock
		// ��дrun();
		// �����¶���;
		// ����Thread()����
		// thread����.start(); 
		 /*LockRunnable lock1=new LockRunnable(true); 
		 LockRunnable lock2=new LockRunnable(false); 
		 Thread t1=new Thread(lock1);
		 Thread t2=new Thread(lock2); 
		 t1.start(); t2.start();*/
		//System.out.println(Thread.currentThread().getName()+"---------");
	}
}

// ʵ�������߳�ͬʱ��ӡ���ֺ��ַ�?
class LockWait implements Runnable {
	private static int total = 5;
	private Lock lock = new ReentrantLock();
	private static String result = "abcdefghij";

	@Override
	public void run() {
		while (total > 0) {
			try {
				lock.lock();
				Thread.sleep(1000);  //���ͷ���
				lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + (total--));
		}
	}
}