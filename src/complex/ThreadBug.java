package complex;

public class ThreadBug {

	static int x=0,y=0,a=0,b=0;
	public static void main(String[] args) throws InterruptedException {

	 //两个线程共享变量，1先执行，2后执行，3插入执行,三种情况。
			Thread one=new Thread(new Runnable() {

				@Override
				public void run() {
					a=1;
					x=b;
				} 
			});
			Thread two=new Thread(new Runnable() {

				@Override
				public void run() {
					b=1;
					y=a;
				} 
			});
			one.start();
			two.start();
			one.join();
			two.join();
			System.out.println(x+","+y);   //0,1   1,1  1,0   one先执行，two先执行，和插入执行。
		 
	}
}
