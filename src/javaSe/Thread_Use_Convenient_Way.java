package javaSe;

public class Thread_Use_Convenient_Way {

	public static void main(String[] args) {
		//1 匿名内部类
		/*new 类名或者接口名() {
			 	 重写方法;
			 };*/
		new Thread() {
			public void run() {
				for(int x=0;x<10;x++) {
					System.out.println(Thread.currentThread().getName()+":"+x);
				}
			}
		}.start();  //Thread自身的线程
		//2
		new Thread(new Runnable() {
			public void run() {
				for(int x=0;x<10;x++) {
					System.out.println(Thread.currentThread().getName()+":"+x);
				}
			}
		}) {}.start(); //传给Thread的runnable线程
		//3
		new Thread(new Runnable() {
			public void run() {
				for(int x=0;x<10;x++) {
					System.out.println("hallo"+Thread.currentThread().getName()+":"+x);
				}
			}
		}) {
			public void run() {
				for(int x=0;x<10;x++) {
					System.out.println("world"+Thread.currentThread().getName()+":"+x);
				}
			}
		}.start();	//运行的是方法体的线程子类的线程
		 //即有自身又有runnable  ()内的线程没反应
	}

}
