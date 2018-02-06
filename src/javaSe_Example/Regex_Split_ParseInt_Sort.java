package javaSe_Example;

import java.util.Arrays;
/*
 * split(" ");
 * Integer.parseInt("21");
 */
public class Regex_Split_ParseInt_Sort {

	public static void main(String[] args) {
		String s = "91 27 46 38 50 25";
		String[] split = s.split(" ");
		System.out.println(Arrays.toString(split));

		int[] arr = new int[6];
		for (int x = 0; x < split.length; x++) {
			arr[x] = Integer.parseInt(split[x]);
		} // 添加到int数组
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		/*String result = "";
		for (int x = 0; x < arr.length; x++) {
			result = result + String.valueOf(arr[x] + ", ");
		} // 数组转回spring
		System.out.println(result);*/
		
		String s1="13000000000";
		String regex="1[34578]\\d{9}";// 字符串匹配正则
		System.out.println("s1 is or not a Phone num ===== "+s1.matches(regex));
		
		//split分割
		s="aa,bb,cc";
		split = s.split("\\,");
		System.out.println(Arrays.toString(split));
		
		s="bb.cc.dd";
		split = s.split("\\.");
		System.out.println(Arrays.toString(split));
		
		s="aa      vv    dd  cc  ee";
		split = s.split(" +");
		System.out.println(Arrays.toString(split));
		
		s="D:\\a\\b\\c\\d";
		split = s.split("\\\\");
		System.out.println(Arrays.toString(split));
		
		s="s2df3oaij345sd5foi435ajs5dfi5j33klj345lk435l3k453kl45j3";
		regex="\\d+";
		s1="*v*";
		String replaceAll = s.replaceAll(regex, s1);
		System.out.println(replaceAll);	
	}
}
