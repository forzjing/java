package interview;

public class Thread_Runnable {

	public static void main(String[] args) {
		
		//����
		new Thread(new Runnable(){  //����
			public void run(){
				System.out.println("runnable run");	
			}
		})
		{
			public void run(){
				System.out.println("subthread run");
			}
		}.start();  //�����subthread run 
		try {
			Thread.sleep(10);
			}catch(InterruptedException e){}// ���������߳���΢ͣһ�£�ģ��cpu	�л������ 			
	}
}
