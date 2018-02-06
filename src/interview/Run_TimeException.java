package interview;

public class Run_TimeException {

	public static void main(String[] args) {
		try {
			String s="11223344";
		//	Integer integer=s;   //runtimeException
	//		System.out.println(integer);
		}catch(ClassCastException c) {
			System.out.println("ClassCastException");
		}
		System.out.println("game over");
	}

}
