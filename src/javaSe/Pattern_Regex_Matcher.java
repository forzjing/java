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
		//静态方法compile 编译规则为模型
		Pattern p=Pattern.compile(regex);
		//非静态方法matcher 字符串匹配规则模型
		Matcher m=p.matcher(s);System.out.println(m.find());  //true
		//为true时获取所有结果
		while(m.find()) {
			System.out.print(m.group()+", ");
		}
	}

}
