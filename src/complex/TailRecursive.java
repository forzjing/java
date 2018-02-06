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
	{//尾递归，n==1,返回  (和+1) 就是 result+n;
		if(n==1) { return result+1; }
		return tailDigui(result+n,n-1);
	}
}
