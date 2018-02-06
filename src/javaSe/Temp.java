package javaSe;

import java.util.Arrays;

public class Temp {

	public static void main(String[] args) {
		byte [] b=new byte[10];
		byte x=0;
		for (byte c : b) {
			b[x]=x;
			x++;
		}
		System.out.println(Arrays.toString(b));
		b=null;
		System.out.println(Arrays.toString(b));
		for (byte c : b) {
			System.out.println(c);
		}
	}

}
