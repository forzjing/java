package interview;

public class IntegerEquals {
public static void main(String[] args) {
	Integer i1=127, i2=127,i3=128,i4=128;
	System.out.println(i1==i2);
	System.out.println(i1.equals(i2));
	System.out.println(i3==i4);
	System.out.println(i3.equals(i4));
	// true true false true
}
	
}
