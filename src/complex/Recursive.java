package complex;

public class Recursive {

	public static void main(String[] args) {

	 	int result=fibonacciRecursive(10);
		System.out.println(result); 
		int result1=fibonacciTailRecursive(10,0,1);
		System.out.println(result1);

	}
	//�ݹ�
	static int fibonacciRecursive(int n)
	{  //�����ġ��Ʋ����ơ�����
		if(n<2)
			return n;
		return (fibonacciRecursive(n-1)+fibonacciRecursive(n-2));
	}
	//β�ݹ�
	static int fibonacciTailRecursive(int n,int acc1,int acc2)
	{
		if(n==0)
			return acc1; 
		return fibonacciTailRecursive(n-1,acc2,acc1+acc2); 
	}
}
