package interview;

public class Outer_Inner_New_Object {
	
	public static void main(String[] args) {
		//1 第一个可是编译通过，并运行。
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
		//第二个编译失败，因为匿名内部类是一个子类对象，当用Object的obj引用指向时，就被提升为了
		//Object类型，而编译时检查Object类中是否有show方法，所以编译失败。


	}
}
