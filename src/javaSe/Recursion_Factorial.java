package javaSe;

public class Recursion_Factorial {
//C:构造方法不能递归使用
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
	 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问第二十个月的兔子对数为多少？
	 * 分析：我们要想办法找规律
	 * 			兔子对数
	 * 第一个月： 	1
	 * 第二个月：	1
	 * 第三个月：	2
	 * 第四个月：	3	
	 * 第五个月：	5
	 * 第六个月：	8
	 * ...
	 * 
	 * 由此可见兔子对象的数据是：
	 * 		1,1,2,3,5,8...
	 * 规则：
	 * 		A:从第三项开始，每一项是前两项之和
	 * 		B:而且说明前两项是已知的
	 */
	private static int rabbit(int n) {
		if(n ==1 || n==2) {
			return 1;
		}else {
			return rabbit(n-1)+rabbit(n-2);
		}
	}
}
