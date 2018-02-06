package javaSe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList_Ergodic {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		// 1
		for (String s : list) {
			System.out.print(s + ",");
		}
		System.out.println("\r\n");
		// 2
		for (int x = 0; x < list.size(); x++) {
			String s = list.get(x);
			System.out.print(s + ",");
		}
		System.out.println("\r\n");
		// 3
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.print(s + ",");
		}
		System.out.println("\r\n");
		// 4
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String s = listIterator.next();
			System.out.print(s + ",");
		}
		// ListIterator set方法
		System.out.println("\r\n");
		ListIterator<String> listIterator1 = list.listIterator();
		for (int x = 0; x < list.size(); x++) {
			listIterator1.next();
			listIterator1.set(String.valueOf(x) + String.valueOf(x + 1));
		}
		System.out.println(list);
		// ListIterator set方法
		List<Character> aList = new ArrayList<Character>();
		aList.add('1');
		aList.add('1');
		aList.add('1');
		aList.add('1');
		aList.add('1');
		aList.add('1');
		aList.add('1');
		aList.add('1');
		aList.add('1');
		byte[] b = new byte[9];
		for (byte x = 0; x < b.length; x++) {
			b[x] = (byte) (x + 65);
		}
		ListIterator<Character> listIterator2 = aList.listIterator();
		for (int x = 0; x < aList.size(); x++) {
			listIterator2.next();
			listIterator2.set((char) b[x]);
		}
		System.out.println(aList);
	}
}
