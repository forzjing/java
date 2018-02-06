package javaSe;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date_Calendar_Format {
/*
 * public SimpleDateFormat(String pattern);
 * format方法是父类DateFormat方法
 */
	public static void main(String[] args) throws ParseException {
		long startTime=System.currentTimeMillis();
		//use Date
		System.out.println("\r"+"---------------------------------");
		Date date=new Date();
		System.out.println(date);  //Tue Nov 08 10:00:45 CST 2016
		SimpleDateFormat sdf1=new SimpleDateFormat();
		String string=sdf1.format(date);
		System.out.println(string);//16-11-8 上午10:00
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		string=sdf2.format(date);
		System.out.println(string);//2016/11/08 10:02:46
		Date parse = sdf2.parse(string);
		System.out.println(parse);//Tue Nov 08 10:04:24 CST 2016
		
		System.out.println("\r"+"---------------------------------");
		Scanner sc1=new Scanner(System.in);
		System.out.println("userYear");
		int userYear=sc1.nextInt();
		//Date SimpleDateFormat
		SimpleDateFormat sdf= new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
		long time=System.currentTimeMillis();
		Date d=new Date();
		Date d0=new Date(time);
		String s=sdf.format(d0);
		System.out.println(d);
		System.out.println(s);
		
		//Calendar
		System.out.println("\r"+"---------------------------------");
		Calendar c= Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int day=c.get(Calendar.DATE);
		System.out.print(year+" "+(month+1)+" "+day+"\r");
		//Set Calendar getFebruary c.get(Calendar.DAY_OF_MONTH);
		c.set(userYear, 2,1);
		c.add(Calendar.DATE, -1);
		System.out.println("Calendar.DAY_OF_MONTH:"+c.get(Calendar.DAY_OF_MONTH)+
				" "+c.get(Calendar.YEAR)+" "+(c.get(Calendar.MONTH)+1)+" "+c.get(Calendar.DATE));
		System.out.println(c);
		
	    //Compute_Date_Subtracting
		System.out.println("\r"+"---------------------------------");
		System.out.println("\r"+"Compute_Date_Subtracting 1986-01-01");
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		
		DateFormat f1=DateFormat.getDateInstance();
		Date d1=f1.parse(s1);
		Date d2=f1.parse(s2);
		
		long time1=d1.getTime();
		long time2=d2.getTime();
		long resultTime=time1-time2;
		System.out.println("subtracting Time: "+resultTime/1000/60/60/24);
		sc.close();	
		
		//use Calendar
		System.out.println("\r"+"---------------------------------");
		Calendar nowCalendar=Calendar.getInstance();
		nowCalendar.get(Calendar.YEAR);
		nowCalendar.get(Calendar.MONTH);
		nowCalendar.get(Calendar.DATE);
		
		nowCalendar.add(Calendar.YEAR, +4);
		year=nowCalendar.get(Calendar.YEAR);
		month=nowCalendar.get(Calendar.MONTH);
		day=nowCalendar.get(Calendar.DATE);
		System.out.println("year: "+year+" month:"+month+" day:"+day);
		
		nowCalendar.set(2016,11,11);
		year=nowCalendar.get(Calendar.YEAR);
		month=nowCalendar.get(Calendar.MONTH);
		day=nowCalendar.get(Calendar.DATE);
		System.out.println("year: "+year+" month:"+month+" day:"+day);
		
		long endTime=System.currentTimeMillis();
		System.out.println("runtime: "+(endTime-startTime));
		}
}
