package javaSe;

import java.math.BigInteger;

public class Encapsulation_Integet_String {
	/*
	 * int���ͺ�String���͵��໥ת��
	 * 
	 * int -- String
	 * 		String.valueOf(number)
	 * 
	 * String -- int
	 * 		Integer.parseInt(s)
	 * 
	 * 
	 * 
	 * public BigInteger[] divideAndRemainder(BigInteger val):�����̺�����������
	 */
	public static void main(String[] args) {
		
			BigInteger bi1 = new BigInteger("100");
			BigInteger bi2 = new BigInteger("50");
			BigInteger[] bis = bi1.divideAndRemainder(bi2);
			System.out.println("�̣�" + bis[0]);
			System.out.println("������" + bis[1]);
				// int -- String
				int number = 100;
				// ��ʽ1
				String s1 = "" + number;
				System.out.println("s1:" + s1);
				// ��ʽ2
				String s2 = String.valueOf(number);
				System.out.println("s2:" + s2);
				// ��ʽ3
				// int -- Integer -- String
				Integer i = new Integer(number);
				String s3 = i.toString();
				System.out.println("s3:" + s3);
				// ��ʽ4
				// public static String toString(int i)
				String s4 = Integer.toString(number);
				System.out.println("s4:" + s4);
				System.out.println("-----------------");

				// String -- int
				String s = "100";
				// ��ʽ1
				// String -- Integer -- int
				Integer ii = new Integer(s);
				// public int intValue()
				int x = ii.intValue();
				System.out.println("x:" + x);
				//��ʽ2
				//public static int parseInt(String s)
				int y = Integer.parseInt(s);
				System.out.println("y:"+y);
	}

}
