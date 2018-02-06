package javaSe;

import java.util.HashSet;
import java.util.Iterator;

public class Collection_HashSet_ {

	public static void main(String[] args) {
		HashSet<String> hSet=new HashSet<>();
		hSet.add("abc1");
		hSet.add("abc2");
		hSet.add("abc3");
		hSet.add("abc4");
		//1
		for (String value : hSet) {
			System.out.print(value+",");
		}
		//2
		Iterator<String> it=hSet.iterator();
		while(it.hasNext()) {
			System.out.print("\t"+it.next()+"\"\"");
		}
	}
}
