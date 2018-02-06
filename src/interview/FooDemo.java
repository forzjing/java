package interview;

public class FooDemo {

	static boolean foo(char c) {
		System.out.println(c);
		return true;
	}
	public static void main(String[] args) {
		int i=0;
		for( foo('a');foo('b')&&(i<2);foo('c')) {
			i++;
			foo('d');
		}
		//abdcbdcb
	}

}
