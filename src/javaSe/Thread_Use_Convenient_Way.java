package javaSe;

public class Thread_Use_Convenient_Way {

	public static void main(String[] args) {
		//1 �����ڲ���
		/*new �������߽ӿ���() {
			 	 ��д����;
			 };*/
		new Thread() {
			public void run() {
				for(int x=0;x<10;x++) {
					System.out.println(Thread.currentThread().getName()+":"+x);
				}
			}
		}.start();  //Thread������߳�
		//2
		new Thread(new Runnable() {
			public void run() {
				for(int x=0;x<10;x++) {
					System.out.println(Thread.currentThread().getName()+":"+x);
				}
			}
		}) {}.start(); //����Thread��runnable�߳�
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
		}.start();	//���е��Ƿ�������߳�������߳�
		 //������������runnable  ()�ڵ��߳�û��Ӧ
	}

}
