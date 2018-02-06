package interview;

public class Try_Finally_Return {
	
	public static void main(String[] args) {
		System.out.println(run());
		//print result:   101 100  
	}

	private static int run() {
		int x=100;
		try {
			return x;
		}finally {
			System.out.println(++x);
		}
	}

}
