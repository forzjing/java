package complex;

public class Compute {

	public static void main(String[] args) {
		 int i=12; 
		// System.out.println(i+=i-=i*=i);
		 int a=i+=i;
		 System.out.println(a);
		 i=12;
		 int b=i*=i;
		 System.out.println(b);
		 System.out.println(a-b);
	}
}
