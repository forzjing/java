package complex;

import java.util.Arrays;

public class SubStringIncriment {

	/*
	 * 截取字符串中递增子串
	 */
	public static void main(String[] args) {
		String str=getSub("asd3si3456789d32345678abcdefghijklmnDF3456lo126789AA");
		System.out.println(str);
	}

	private static String getSub(String string) {
		int len=1;
		int maxLen=1; 
		byte[] bytes = string.getBytes();
		int index=0;
		for (int i=0;i<bytes.length-1;i++) {
			//System.out.println(bytes[i]); 
				if(  bytes[i+1] == bytes[i]+1 )
				{ 
					len++;
				}
				else
				{
					if(len>maxLen)
					{ 
						maxLen=len;
						//System.out.println("++++.."+(char)bytes[i]);
						//System.out.println("----.."+(char)bytes[i-maxLen+1]); 
					//  String substring = string.substring(i-maxLen+1,i+1);
					//  System.out.println(substring);
					 	index=i;
					} 
					len=1;  
				}  
		}
	//	System.out.println(maxLen);
		return string.substring(index-maxLen+1,index+1) ;
	}
 
}
