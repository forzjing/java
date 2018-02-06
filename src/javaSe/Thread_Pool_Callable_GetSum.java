package javaSe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_Pool_Callable_GetSum {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
/*
 * 线程池的第二种方法callable可以有返回值 用来求和
 */	
		  ExecutorService pool=Executors.newFixedThreadPool(2);
		  int num=100;
		  Future<Integer> f1=pool.submit(new MyCallable(100));
		  Future<Integer> f2=pool.submit(new MyCallable(200));
		  
		  Integer i1=f1.get();
		  Integer i2=f2.get();
		  
		  System.out.println(i1);
		  System.out.println(i2);
		  
		  //关闭线程池
		  pool.shutdown();
		  
	}

}
class MyCallable implements Callable<Integer>{// 代表线程
	private int number;
	public MyCallable() {}
	public MyCallable(int number) {
		this.number=number;
	}
	public Integer call()throws Exception{
		int sum=0;
		for(int x=1;x<=number;x++) {
			sum+=x;
		}
		return sum;
	}
}
