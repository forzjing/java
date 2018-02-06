package javaSe_Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Date_GetMyTime {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		System.out.println("input your birthday yyyy-MM-dd");
		
		Date d=new Date();
		long time = d.getTime();  //System.currentTimeMillis();
		
		SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
		String s=sc.nextLine();
		Date d1=f1.parse(s);
		
		long myTime=d1.getTime();
		long result=time-myTime;
		
		System.out.println("result: "+result);
		long day=result/1000/60/60/24;
		long year=day/365;
		long month=year*12;
		System.out.println("day:"+day+"  year:"+year+"  month:"+month);	
	}
}
