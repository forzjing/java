package complex;

public class TailRecursive {

	public static void main(String[] args) {
		
		int i=digui(10);
		System.out.println(i);
		
		int j=tailDigui(0,10);
		System.out.println(j); 
	}
	
	static int digui(int n)
	{
		if(n==1)
		{
			return n;
		}
		return (  n + digui(n-1) );
	}
	
	static int tailDigui(int result,int n)
	{//β�ݹ飬n==1,����  (��+1) ���� result+n;
		if(n==1) { return result+1; }
		return tailDigui(result+n,n-1);
	}
}
