package javaSe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_Regex_Matcher {
		/*
		 * Pattern p=Patter.compile(regex);
		 * Matcher m=p.matcher(string);
		 * m.find();
		 * m.group();
		 */
	public static void main(String[] args) {
		String s="how are you ,I am very sad, do you know, Iam  so sad";
		String regex= "[a-zA-Z]{3}";  //"\\b\\w{2}\\b"
		//��̬����compile �������Ϊģ��
		Pattern p=Pattern.compile(regex);
		//�Ǿ�̬����matcher �ַ���ƥ�����ģ��
		Matcher m=p.matcher(s);System.out.println(m.find());  //true
		//Ϊtrueʱ��ȡ���н��
		while(m.find()) {
			System.out.print(m.group()+", ");
		}
	}

}
