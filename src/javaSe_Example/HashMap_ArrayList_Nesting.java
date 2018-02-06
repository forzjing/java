package javaSe_Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMap_ArrayList_Nesting {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> hm=new HashMap<>();
		
		ArrayList<String>  list1=new ArrayList<String>();
		list1.add("adam");
		list1.add("eve");
		hm.put("Usa", list1);
		
		ArrayList<String>	list2=new ArrayList<>();
		list2.add("lili");
		list2.add("lilei");
		hm.put("china", list2);
		
		ArrayList<String>	list3=new ArrayList<>();
		list3.add("luffy");
		list3.add("nami");
		hm.put("japan", list3);
		
		Set<String>	set=hm.keySet();
		for(String key:set) {
				
			System.out.println(key);
				
				ArrayList<String> valueList=hm.get(key);
				for (String string : valueList) {
					System.out.println("\t"+string);
				}
		}
	}

}
