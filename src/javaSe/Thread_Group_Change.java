package javaSe;
/*
 * @explain:指定线程的线程组
 * 默认情况线程属于main线程组
 */
public class Thread_Group_Change {

	public static void main(String[] args) {
		ThreadGroup tg=new ThreadGroup("ThreadGroup name is TG");
		
		NewRunnable run=new NewRunnable();
		Thread t1=new Thread(tg,run,"adam");
		Thread t2=new Thread(tg,run,"lili");
		
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());
		//设置为后台线程
		tg.setDaemon(true);
		t1.start();
		t2.start();
	}

}
class NewRunnable implements Runnable{

	@Override
	public void run() {
		for(int x=0;x<5;x++) {
			System.out.println(Thread.currentThread().getName()+":"+x);
		}
	}
	
}
