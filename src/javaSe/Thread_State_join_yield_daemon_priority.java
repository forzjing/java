package javaSe;

import java.util.Date;

public class Thread_State_join_yield_daemon_priority {

	public static void main(String[] args) {
		// �̰߳�ȫ����
		/*
		 * StringBuffer sb=new StringBuffer(); Vector<String> v= new
		 * Vector<String>(); Hashtable<String, String> h=new
		 * Hashtable<String,String>(); List<String>
		 * list=Collections.synchronizedList(new ArrayList<String>());
		 */
		/*
		 * public final void stop():���߳�ֹͣ����ʱ�ˣ����ǻ�����ʹ�á�
		 * public void interrupt():�ж��̡߳� ���̵߳�״̬��ֹ�����׳�һ��InterruptedException��
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
		 * public final void setDaemon(boolean on):�����̱߳��Ϊ�ػ��̻߳��û��̡߳�
		 * ���������е��̶߳����ػ��߳�ʱ��Java ������˳��� �÷��������������߳�ǰ���á� 
		 */
	/*	ThreadDaemon td1 = new ThreadDaemon();
		ThreadDaemon td2 = new ThreadDaemon();
		td1.setDaemon(true);
		td2.setDaemon(true);
		td1.setName("����");
		td2.setName("�ŷ�");

		td1.start();
		td2.start();
		Thread.currentThread().setName("����");
		for (int x = 0; x < 10; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}*/
		
		/*
		 * public final void join():�ȴ����߳���ֹ�� 
		 */
		/*ThreadJoin tj1 = new ThreadJoin();
		ThreadJoin tj2 = new ThreadJoin();
		ThreadJoin tj3 = new ThreadJoin();

		tj1.setName("��Ԩ");
		tj2.setName("������");
		tj3.setName("��Ԫ��");
		
		tj1.start();
		try {
			tj1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		tj2.start();
		tj3.start();*/
		
		//�߳�Ĭ�����ȼ���5��
		// �߳����ȼ��ķ�Χ�ǣ�1-10��
		 //�߳����ȼ��߽�����ʾ�̻߳�ȡ�� CPUʱ��Ƭ�ļ��ʸߣ�����Ҫ�ڴ����Ƚ϶࣬���߶�����е�ʱ����ܿ����ȽϺõ�Ч����
		/*ThreadPriority tp1 = new ThreadPriority();
		ThreadPriority tp2 = new ThreadPriority();
		ThreadPriority tp3 = new ThreadPriority();

		tp1.setName("��������");
		tp2.setName("����Ⱥ");
		tp3.setName("��ƽ֮");
		tp1.setPriority(10);
		tp2.setPriority(1);

		tp1.start();
		tp2.start();
		tp3.start();*/
		
		/*ThreadSleep ts1 = new ThreadSleep();
		ThreadSleep ts2 = new ThreadSleep();
		ThreadSleep ts3 = new ThreadSleep();

		ts1.setName("����ϼ");
		ts2.setName("��־��");
		ts3.setName("��־ӱ");

		ts1.start();
		ts2.start();
		ts3.start();*/
	}

}

class ThreadSleep extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(getName() + ":" + x + ",���ڣ�" + new Date());
			// ˯��
			// ���ˣ�����΢��Ϣ1����
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
			 * public static void yield():��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳� 
			 * �ö���̵߳�ִ�и���г�����ǲ��ܿ�����֤һ��һ�Ρ�
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
		 * public final void setDaemon(boolean on):�����̱߳��Ϊ�ػ��̻߳��û��̡߳�
		 * ���������е��̶߳����ػ��߳�ʱ��Java ������˳��� �÷��������������߳�ǰ���á� 
		 */
	}
}
class ThreadStop extends Thread {
	@Override
	public void run() {
		System.out.println("��ʼִ�У�" + new Date());

		// ��Ҫ��Ϣ10���ӣ��ף���Ҫ������Ŷ
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println("�̱߳���ֹ��");
		}

		System.out.println("����ִ�У�" + new Date());
	}
}