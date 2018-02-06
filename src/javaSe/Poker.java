package javaSe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;


public class Poker {
	
	public String name;
	public int num;
	private String quality;
	
	public Poker(String name) {
		super();
		this.name = name;
	}

	public Poker() {
		super();
	}

	public Poker(String name, int num, String quality) {
		super();
		this.name = name;
		this.num = num;
		this.quality = quality;
	}

	public static void main(String[] args) {
		TreeMap<Integer, String> t=new TreeMap<>();
		ArrayList<Integer> a= new ArrayList<>();
		
		String[] s= new String[] {"a","b","c","d"};
		String[] i= new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		int index=0;
		for (String id : i) {
			for (String value : s) {
				String concat= value.concat(id);
				t.put(index,concat);
				a.add(index);
				index++;
			}
		}
		
		t.put(index, "jocker");
		a.add(index);
		index++;
		t.put(index,"jocker1");
		a.add(index);
		
		Collections.shuffle(a);
		TreeSet<String>  p1= new TreeSet<>();
		TreeSet<String>  p2= new TreeSet<>();
		TreeSet<String>  p3= new TreeSet<>();
		TreeSet<String>  p4= new TreeSet<>();
		
		for(int x=0;x<a.size();x++) {
			if(x>=a.size()-3) {
				p4.add(t.get(a.get(x)));
			}else if(x%3 ==0) {
				p1.add(t.get(a.get(x)));
			}else if(x%3 ==1) {
				p2.add(t.get(a.get(x)));
			}else if(x%3 ==2) {
				p3.add(t.get(a.get(x)));
			}
		}
		ergodic ("p4",p4);
		ergodic ("p2",p2);
		ergodic ("p3",p3);
		ergodic ("p1",p1);
	}

	private static void ergodic(String name, TreeSet<String> user) {
		System.out.println(name+":");
		for(String value: user ) {
			System.out.print(value+",");
		}
		System.out.println("\r");
	}

	@Override
	public String toString() {
		return "Poker [name=" + name + ", num=" + num + ", quality=" + quality + "]";
	}
	
	
}
