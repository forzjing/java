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
 * 统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
 */
class CharacterCount {
	public static void main(String[] args) {
		// 定义三个统计变量。
		int bigCount = 0;
		int smallCount = 0;
		int numberCount = 0;

		// 键盘录入一个字符串。
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String line = sc.nextLine();

		// 把字符串转换为字符数组。
		char[] chs = line.toCharArray();

		// 历字符数组获取到每一个字符
		for (int x = 0; x < chs.length; x++) {
			char ch = chs[x];

			// 判断该字符
			if (Character.isUpperCase(ch)) {
				bigCount++;
			} else if (Character.isLowerCase(ch)) {
				smallCount++;
			} else if (Character.isDigit(ch)) {
				numberCount++;
			}
		}

		// 输出结果即可
		System.out.println("大写字母：" + bigCount + "个");
		System.out.println("小写字母：" + smallCount + "个");
		System.out.println("数字字符：" + numberCount + "个");
	}
}