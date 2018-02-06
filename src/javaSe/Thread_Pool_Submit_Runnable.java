package javaSe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Pool_Submit_Runnable {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());//4个线程的线程池,多了不执行
		
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		pool.shutdown();
	}

}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}
	}
}