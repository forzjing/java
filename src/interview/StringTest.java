package interview;
public class StringTest {

	public static void change(String string){
		string="chang";
	}
	/*
	 * ��������string����ı䣬����Ϊ��Ա���Կ��ܸı�
	 */
	public static void main(String[] args) {
		String string="default";
		change(string);
		System.out.println(string);
		
		String s1 = "abc"; // s1ָ����ڴ���ֻ��һ������abc��
		String s2 = new String("abc"); // s2ָ�������������������abc��new ��

		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true ���ַ�����equals�Ƚϵ����ַ��������Ƿ���ͬ��
 
	}
}
