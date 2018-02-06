package interview;
public class StringTest {

	public static void change(String string){
		string="chang";
	}
	/*
	 * 主方法的string不会改变，定义为成员属性可能改变
	 */
	public static void main(String[] args) {
		String string="default";
		change(string);
		System.out.println(string);
		
		String s1 = "abc"; // s1指向的内存中只有一个对象abc。
		String s2 = new String("abc"); // s2指向的内容中有两个对象abc、new 。

		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true ，字符串中equals比较的是字符串内容是否相同。
 
	}
}
