package javaSe;

public class Recursion_Factorial {
//C:���췽�����ܵݹ�ʹ��
	public static void main(String[] args) {
		 
		System.out.println(factorial(5));
		System.out.println(rabbit(10));
	}


	private static int factorial(int n) {
		if(n==1) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
	/*
	 * ��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ��������ʵڶ�ʮ���µ����Ӷ���Ϊ���٣�
	 * ����������Ҫ��취�ҹ���
	 * 			���Ӷ���
	 * ��һ���£� 	1
	 * �ڶ����£�	1
	 * �������£�	2
	 * ���ĸ��£�	3	
	 * ������£�	5
	 * �������£�	8
	 * ...
	 * 
	 * �ɴ˿ɼ����Ӷ���������ǣ�
	 * 		1,1,2,3,5,8...
	 * ����
	 * 		A:�ӵ����ʼ��ÿһ����ǰ����֮��
	 * 		B:����˵��ǰ��������֪��
	 */
	private static int rabbit(int n) {
		if(n ==1 || n==2) {
			return 1;
		}else {
			return rabbit(n-1)+rabbit(n-2);
		}
	}
}
