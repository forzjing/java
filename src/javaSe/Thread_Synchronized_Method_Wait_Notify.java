package javaSe;

import java.io.IOException;

class GetThread implements Runnable {
	private SynMethod s;

	public GetThread(SynMethod s) {
		this.s = s;
	}

	public void run() {
		while (true) {
			s.get();
		}
	}
}

class SetThread implements Runnable {
	private SynMethod s;
	private int x = 0;

	public SetThread(SynMethod s) {
		this.s = s;
	}

	public void run() {
		while (true) {
			if (x % 2 == 0) {
				s.set("adam", 22);
			} else {
				s.set("lili", 33);
			}
			x++;
		}
	}
}

public class Thread_Synchronized_Method_Wait_Notify {
	public static void main(String[] args) {
		/*SynMethod s = new SynMethod();
		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);

		t1.start();
		t2.start();*/
		
		//ͬ��д�ڷ�����
		SynPiece sp=new SynPiece();
		SetThread1 st1=new SetThread1(sp);
		GetThread1 gt1=new GetThread1(sp);
		Thread th3=new Thread(st1);
		Thread th4=new Thread(gt1);
		th3.start();
		th4.start();
	}
}

class SynMethod {
	private String name;
	private int age;
	private boolean flag;

	public synchronized void set(String name, int age) {
		if (this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.age = age;
		this.flag = true;
		this.notify();  //t1���ѵȴ����߳�
	}

	public synchronized void get() {
		if (!this.flag) {
			try {
				this.wait();   //�ȴ�ͬʱ�ͷ��� ԭ����������ִ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name + "---" + this.age);
		this.flag = false;
		this.notify();
	}
}
//��һ�ַ���
class SynPiece {
	String name;
	int age;
	boolean flag;
}
class SetThread1 implements Runnable{
	private SynPiece s;
	private int x=0;
	public SetThread1(SynPiece s) {
		this.s=s;
	}
	public void run() {
		while(true) {
			synchronized(s) {
				if(s.flag) {
					try {
						s.wait();  //�ͷ��� �ȴ�
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(x%2==0) {
					s.name="lilei";
					s.age=22;
				}else {
					s.name="limin";
					s.age=30;
				}
				x++;
				s.flag=true;
				s.notify();//����t2�߳�,  t1,t2ͬʱִ��
			}
		}
	}
}

class GetThread1 implements Runnable{
	private SynPiece s;
	public GetThread1(SynPiece s) {
		this.s=s;
	}
	public void run() {
		while(true) {
			synchronized(s) {
				if(!s.flag) {
					try {
						s.wait(); //t2�ȴ�
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(s.name+":::"+s.age);
				s.flag=false;
				s.notify();//����t1
			}
		}
	}
}
