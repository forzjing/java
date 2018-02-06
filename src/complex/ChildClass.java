package complex;

public class ChildClass extends FatherClass{

	int i=3;
	int j=0;
	{
		System.out.println("子类代码块1");
	}
	ChildClass(){
		System.out.println("子类构造方法");
	}
	void out() {
		System.out.println(i+" 子类out方法 "+j);
	}
	static {
		System.out.println("子类静态代码块");
	}
	{
		System.out.println("子类代码块2");
	}
	public static void main(String[] args) {

		/*
父类静态代码块
子类静态代码块
抽象类构造方法           //静态代码块优先于构造方法
父类代码块
父类构造方法			//代码块优先于构造方法				
子类代码块1
子类代码块2
子类构造方法
3 子类out方法 0
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
		System.out.println("父类构造方法");
	}
	@Override
	void out() {
		System.out.println(i+" 父类out方法 "+j);
	}
	static {
		System.out.println("父类静态代码块");
	}
	
	{
		System.out.println("父类代码块");
	}
	
}

abstract class BaseClass{
	int i;
	int j;
	BaseClass(){
		System.out.println("抽象类构造方法");
	}
	abstract void out();
}