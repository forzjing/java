package javaSe;

public class Outer_Inner_Interface {

	public static void main(String[] args) {
		new RealizeInner().nei();
		new RealizeOuter().wai();
	}

}
/*
 * ����һ�������ڲ���
 */
interface Inter{
	void show();
}
class ClassOuter{//ͨ�������ڲ��ಹ��Outer���еĴ��롣
	public static Inter method(){
		return new Inter(){
			public void show(){}
		};
	}
}
class InnerClassTest {
	public static void main(String[] args) {
		ClassOuter.method().show();
	/*
		ClassOuter.method():��˼�ǣ�Outer����һ������Ϊmethod�ķ�����������������Ǿ�̬�ġ�
		ClassOuter.method().show():��Outer����þ�̬��method�������������Ľ���ֵ�����show��������ζ�ţ�method()����������һ���Ƕ��󣬶������������Inter���͵ġ�
	*/
		function (
			new Inter(){ public void show(){} }
		); //�����ڲ�����Ϊ�����Ĳ������д��ݡ�
	}
	public static void function(Inter in){
		in.show();
	}
}


/*
 * �o�B�����{���o�B�ڲ�����o�B�{�÷��o�B
 */
class InnerClass {
	class Inner{
		void show(){}
	}
	public void method(){
		this.new Inner().show();//����
	}
	static class staticInner{
		void show() {}
	}
	public static void main(String[] args) {
		//static������this 
		this.new staticInner().show();//����Inner����Ҫ�����static
	}
}

interface Outer {
	void wai();

	interface Inner {
		void nei();
	}
}

class RealizeInner implements Outer.Inner {
	@Override
	public void nei() {
		System.out.println("Realized Inner interface");
	}
}

class RealizeOuter implements Outer {
	@Override
	public void wai() {
		System.out.println("Realized Outer interface");
	}
}
/*
 * �˜��ڲ��
 */
class OuterClass{
	int num = 4;	
	class  Inner {
		void show(){
			System.out.println("inner show run "+num);			
		}
	}
	public void method(){
		Inner in = new Inner();//�����ڲ���Ķ���
		in.show();//�����ڲ���ķ����� 
	}
}


