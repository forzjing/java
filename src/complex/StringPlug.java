package complex;

public class StringPlug {

	public static void main(String[] args) {

		String s1="a";
		String s2=s1+"b";
		System.out.println(s2=="ab");  //false;
		
		String s3="ab"+"cd";
		String s4="abcd";
		System.out.println(s3==s4);  //true;
		
		
		
		
	}

}
