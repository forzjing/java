package interview;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSplit {
	/*
	 * ����1|2|2|3|4|45|5|6|
	 * ��ȥ�ָ����������򣬶��ַ����Ż�
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine(); 
		/*
		 * String.split("|")
		 * String.toCharArray()
		 * String.getBytes()
		 */
		String[] split = string.split("\\|"); 
		Arrays.sort(split);
		System.out.println(Arrays.toString(split));
	}
}
