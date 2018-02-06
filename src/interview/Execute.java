package interview;
  
class A {

	static {
		System.out.println("a static");
	}
	public A() {
		System.out.println("a construct");
	}
}
/*
a static
b static
a construct
b construct
a construct
b construct
 */
class B extends A{
	static {
		System.out.println("b static");
	}
	public B() {
		System.out.println("b construct");
	}
}
public class Execute{
	public static void main(String[] args) {
		A ab=new B();
		ab=new B();
	}
}