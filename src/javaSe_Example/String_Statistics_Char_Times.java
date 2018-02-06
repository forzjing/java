package javaSe_Example;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class String_Statistics_Char_Times {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s= sc.nextLine();
		char[]  charArray= s.toCharArray();
		
		TreeMap<Character,Integer> tMap= new TreeMap<>();
		for(char c: charArray) {
			Integer value= tMap.get(c);
			if(value ==null) {
				tMap.put(c,1);
			}else {
				tMap.put(c, tMap.get(c)+1);
			}
		}
		
		StringBuffer sBuffer= new StringBuffer();
		Set<Character> set= tMap.keySet();
		for (Character key : set) {
			sBuffer.append(key).append("(").append(tMap.get(key)).append(")");
		}
		String result= sBuffer.toString();
		System.out.println(result);
	}
}

/*
 * ͳ��һ���ַ����д�д��ĸ�ַ���Сд��ĸ�ַ��������ַ����ֵĴ�����(�����������ַ�)
 */
class CharacterCount {
	public static void main(String[] args) {
		// ��������ͳ�Ʊ�����
		int bigCount = 0;
		int smallCount = 0;
		int numberCount = 0;

		// ����¼��һ���ַ�����
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String line = sc.nextLine();

		// ���ַ���ת��Ϊ�ַ����顣
		char[] chs = line.toCharArray();

		// ���ַ������ȡ��ÿһ���ַ�
		for (int x = 0; x < chs.length; x++) {
			char ch = chs[x];

			// �жϸ��ַ�
			if (Character.isUpperCase(ch)) {
				bigCount++;
			} else if (Character.isLowerCase(ch)) {
				smallCount++;
			} else if (Character.isDigit(ch)) {
				numberCount++;
			}
		}

		// ����������
		System.out.println("��д��ĸ��" + bigCount + "��");
		System.out.println("Сд��ĸ��" + smallCount + "��");
		System.out.println("�����ַ���" + numberCount + "��");
	}
}