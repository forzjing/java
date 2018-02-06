package javaSe;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Encapsulation_Big_Decimal_Integer_asmd {
//public BigDecimal divide(BigDecimal divisor,int scale,int roundingMode)
	//商，几位小数，如何舍取
	public static void main(String[] args) {
		
		BigDecimal bd7 = new BigDecimal("1.301");
		BigDecimal bd8 = new BigDecimal("100");
		System.out.println("divide:" + bd7.divide(bd8));
		System.out.println("divide:"
				+ bd7.divide(bd8, 3, BigDecimal.ROUND_HALF_UP));
		System.out.println("divide:"
				+ bd7.divide(bd8, 8, BigDecimal.ROUND_HALF_UP));
		System.out.println("------------------");
		
		BigInteger b1=new BigInteger("222222234234242423423423423424234");
		BigInteger b2=new BigInteger("233342342422419189858685856855584");
		BigInteger b=b1.add(b2);
		System.out.println(b);
		b=b1.subtract(b2);
		System.out.println(b);
		b=b1.multiply(b2);
		System.out.println(b);
		b=b1.divide(b2);
		System.out.println(b);
		
		System.out.println("------------------");
		BigDecimal d1=new BigDecimal("100000000.123");
		BigDecimal d2=new BigDecimal("100000000.123");
		BigDecimal d=d1.add(d2);
		System.out.println(d);
		d=d1.subtract(d2);
		System.out.println(d);
		d=d1.multiply(d2);
		System.out.println(d);
		d=d1.divide(d2);
		System.out.println(d);
		System.out.println("--------------------");
		System.out.println(d1.scale());
		System.out.println(d2.scale());
		System.out.println("--------------------");
		
		Integer integer =new Integer("65535");
		int j= integer.intValue();
		String string= Integer.toString(j, 2);
		String[] split = string.split("");
		for (String stringSplit : split) {
			System.out.print(stringSplit+", ");
		}System.out.println("16bit");
		
		System.out.println("\r");
		Integer i =new Integer("255");
		int j1= i.intValue();
		String s= Integer.toString(j1, 2);
		String[] sp = s.split("");
		for (String sSplit : sp) {
			System.out.print(sSplit+", ");
		}System.out.println("8bit");
	}

}
