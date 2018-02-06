package javaSe;

import java.util.Arrays;
import java.util.Scanner;

public class String_Reverse_Statistics {

	public static void main(String[] args) {
		Character c=new Character('a');
		System.out.println(c.SIZE);//�����ֶ�ֵ
		System.out.println(Character.SIZE);//�����ֶ�ֵ
		//����СдСд
		String s = "how Old ArE YoU.";
		String sub1 = s.substring(0, 1);
		String sub2 = s.substring(1);
		s = sub1.toUpperCase().concat(sub2.toLowerCase());
		System.out.println(s);
		// reverse
		char[] ch = s.toCharArray();
		String result = "";
		for (int x = ch.length - 1; x >= 0; x--) {
			result += ch[x];
		}
		System.out.println(result);

		// trim replace
		s = "   how do you do   ";
		s = s.trim();
		s = s.replace(" ", ",");
		System.out.println(s);

		// statistics
		String max = "dkfdkaijdfdkdkdjkdkdfjkdjfdkfkdkdfkdfdkfkd";
		String min = "dk";
		System.out.println(locating(max, min));

		// sort
		s = "afghjkloiuytrewqj";
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		s = Arrays.toString(charArray);
		System.out.println(s);
		
		Scanner sc= new Scanner(System.in);
		 // �ַ����Ƿ�Գ�
		s=sc.next();
		System.out.println(judge(s)); 
		
		//���˶���ؼ���
		s=sc.next();
		System.out.println(filter(s));
	}
		private static String filter(String s) {
			String [] keys= {"������","���","���","���㹷��"};
			s=s.replaceAll(",", "||"); //��Ҫ���¸�ֵ��ԭ�ַ���s.replaceAll(regex, replacement)
			for(int i=0;i<keys.length;i++) {
					s = s.replace(keys[i], "***");   //s.replace(oldChar, newChar)
			}
			return s;
		}

		private static String judge(String s) {
			StringBuffer sb= new StringBuffer(s);
			if(sb.reverse().toString().equals(s)) {
				return s;
			}else {
					return "It is not a symmetrical string"; 
			}
		}

		private static String locating(String max, String min) {
			int count = 0;
			int index = 0;
			while ((index = max.indexOf(min)) >= 0) {
				count++;
				max = max.substring(index + min.length());
			}
			return "found String \t" + count + " " + "times";
		}

}
