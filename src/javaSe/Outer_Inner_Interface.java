package javaSe;

public class Outer_Inner_Interface {

	public static void main(String[] args) {
		new RealizeInner().nei();
		new RealizeOuter().wai();
	}

}
/*
 * 返回一个匿名内部类
 */
interface Inter{
	void show();
}
class ClassOuter{//通过匿名内部类补足Outer类中的代码。
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
		ClassOuter.method():意思是：Outer中有一个名称为method的方法，而且这个方法是静态的。
		ClassOuter.method().show():当Outer类调用静态的method方法运算结束后的结果又调用了show方法，意味着：method()方法运算完一个是对象，而且这个对象是Inter类型的。
	*/
		function (
			new Inter(){ public void show(){} }
		); //匿名内部类作为方法的参数进行传递。
	}
	public static void function(Inter in){
		in.show();
	}
}


/*
 * 靜態方法調用靜態内部類，非靜態調用非靜態
 */
class InnerClass {
	class Inner{
		void show(){}
	}
	public void method(){
		this.new Inner().show();//可以
	}
	static class staticInner{
		void show() {}
	}
	public static void main(String[] args) {
		//static不允许this 
		this.new staticInner().show();//错误，Inner类需要定义成static
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
 * 標準内部類
 */
class OuterClass{
	int num = 4;	
	class  Inner {
		void show(){
			System.out.println("inner show run "+num);			
		}
	}
	public void method(){
		Inner in = new Inner();//创建内部类的对象。
		in.show();//调用内部类的方法。 
	}
}


