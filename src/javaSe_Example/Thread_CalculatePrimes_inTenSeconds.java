package javaSe_Example;

import java.util.Arrays;

public class Thread_CalculatePrimes_inTenSeconds extends Thread { 
	
	/*
	 * 十秒内可以计算出多少素数
	 */
	public static final int MAX_PRIMES = 10; //1000000
	public static final int TEN_SECONDS = 10000;
	public volatile boolean finished=false;
	
	public void run()
	{
		int [] primes=new int[MAX_PRIMES];
		int count=0;
		for(int i=2;count<MAX_PRIMES;i++)
		{ 
			if(finished)
			{
				break;
			}
			boolean prime=true;
			for(int j=0;j<count;j++)
			{  
				if( i % primes[j] == 0)  //???
				{
					prime=false;
					break;
				}
			}
			if(prime)
			{
				primes[count++] =i;
				System.out.println("Found prime: "+i);
			}
		}
	}
	public static void main(String[] args) {
		Thread_CalculatePrimes_inTenSeconds calculator = new Thread_CalculatePrimes_inTenSeconds();
		calculator.start();
		try {
			Thread.sleep(TEN_SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calculator.finished = true;
	}

}
