package javaSe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Collection_Transform {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		list.add("abc1");
		list.add("abc1");
		list.add("abc1");
		list.add("abc1");
		Object[] array = list.toArray();
		System.out.print("Object []: ");
		for (Object object : array) {
			System.out.print(object+", ");
		}
		
		System.out.println("");
		List<Object> asList = Arrays.asList(array);
		System.out.print("Collection : ");
		for (Object object : asList) {
			System.out.print(object+", ");
		}
	}
}
