package interview;

public class Outer_Inner_New_Object {
	
	public static void main(String[] args) {
		//1 ��һ�����Ǳ���ͨ���������С�
		new Object(){
			void show(){
				System.out.println("show run");				
			}
		}.show();
		//2
		Object obj = new Object(){
			void show(){
				System.out.println("show run");
			}
		};
		obj.show();
		//�ڶ�������ʧ�ܣ���Ϊ�����ڲ�����һ��������󣬵���Object��obj����ָ��ʱ���ͱ�����Ϊ��
		//Object���ͣ�������ʱ���Object�����Ƿ���show���������Ա���ʧ�ܡ�


	}
}
