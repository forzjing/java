package interview;

public class Thread_Runnable {

	public static void main(String[] args) {
		
		//面试
		new Thread(new Runnable(){  //匿名
			public void run(){
				System.out.println("runnable run");	
			}
		})
		{
			public void run(){
				System.out.println("subthread run");
			}
		}.start();  //结果：subthread run 
		try {
			Thread.sleep(10);
			}catch(InterruptedException e){}// 当刻意让线程稍微停一下，模拟cpu	切换情况。 			
	}
}
