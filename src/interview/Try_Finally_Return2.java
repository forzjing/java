package interview;

public class Try_Finally_Return2 {

	public static void main(String[] args) {
		System.out.println(run());
		//  fun1  fun2 2000
	}

	@SuppressWarnings("finally")
	private static int run() {
		try {
			return fun1();
		}finally {
			return fun2();
		}
	 
	}
	
	private static int fun1() {
		System.out.println("fun1");
		return 100;
	}
	private static int  fun2() {
		System.out.println("fun2");
		return 2000;
	}

}
