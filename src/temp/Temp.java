package temp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Temp {

	public static void main(String[] args) {
		System.out.println(Math.round(-11.5));
		System.out.println(Math.round(11.5));
		int [] a=new int [2];
		System.out.println(a.length);
		
		
	}
	
	@Test
	public void testFitndMatches() {
	   
	   String input = "Do you run? Ran? No, bro, run! Bro, I ran and run.";
	   
	   String regex = "r[au]n";
	   
	   Pattern pattern = Pattern.compile(regex);
	   Matcher matcher = pattern.matcher(input);
	   
	   int matchCount = 0;
	   StringBuilder matchHolder = new StringBuilder();
	   while (matcher.find()) {
	   if (matchCount > 0)  {
		   matchHolder.append(',');   
	   }
	   matchHolder.append(matcher.group());
	   matchCount++;
	   }
	   
	   System.out.println("Matches: " + matchHolder.toString());
	   
	}

}
