package complex;

public class ChildClass extends FatherClass{

	int i=3;
	int j=0;
	{
		System.out.println("��������1");
	}
	ChildClass(){
		System.out.println("���๹�췽��");
	}
	void out() {
		System.out.println(i+" ����out���� "+j);
	}
	static {
		System.out.println("���ྲ̬�����");
	}
	{
		System.out.println("��������2");
	}
	public static void main(String[] args) {

		/*
���ྲ̬�����
���ྲ̬�����
�����๹�췽��           //��̬����������ڹ��췽��
��������
���๹�췽��			//����������ڹ��췽��				
��������1
��������2
���๹�췽��
3 ����out���� 0
3--0
		 */
		FatherClass f=new ChildClass();
		f.out();
		System.out.println(f.i+"--"+f.j);
	}

}

class FatherClass extends BaseClass{

	int i=3;
	int j=0;
	FatherClass(){
		System.out.println("���๹�췽��");
	}
	@Override
	void out() {
		System.out.println(i+" ����out���� "+j);
	}
	static {
		System.out.println("���ྲ̬�����");
	}
	
	{
		System.out.println("��������");
	}
	
}

abstract class BaseClass{
	int i;
	int j;
	BaseClass(){
		System.out.println("�����๹�췽��");
	}
	abstract void out();
}