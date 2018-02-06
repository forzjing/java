package javaSe_Copy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Nesting_HashMap {

	public static void main(String[] args) {
		Map<String, HashMap<String, Integer>> country=new HashMap<>();
		HashMap<String, Integer> hm1=new HashMap<>();
		HashMap<String , Integer> hm2=new HashMap<>();
		hm1.put("male", 30);
		hm1.put("female", 29);
		/*Collection<Integer> collection=hm1.values();
		for (Integer value : collection) {
			System.out.print(value+", ");
		}
		for (String key : hm1.keySet()) {
			System.out.print(key+", ");
		}
		System.out.println("\r");*/
		country.put("China", hm1);
		
		hm2.put("boy", 16);
		hm2.put("girl", 19);
		country.put("japanese", hm2);
		
		//1
		Set<Entry<String, HashMap<String, Integer>>> entry=country.entrySet();
		for (Entry<String, HashMap<String, Integer>> countryEntry : entry) {
			System.out.println(countryEntry.getKey());
				
				HashMap<String, Integer> countryValue=countryEntry.getValue();
				Set<String> set=countryValue.keySet();
				for (String hmKey : set) {
					Integer hmValue=countryValue.get(hmKey);
					System.out.println("\t"+hmKey+", "+hmValue);
				}
		}
		//2
		
		Set<String> set=country.keySet();
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext()){
			String countryKey=iterator.next();
			System.out.println(countryKey);
			
			HashMap<String, Integer> countryValue = country.get(countryKey);
			Set<String> hmKey = countryValue.keySet();
			Iterator<String> hmIterator=hmKey.iterator();
			while(hmIterator.hasNext()){
				String whmKey=hmIterator.next();
				Integer whmValue=countryValue.get(whmKey);
				System.out.println("\t"+whmKey+"=="+whmValue);
			}
		}
		
		//3
		Set<Entry<String, HashMap<String, Integer>>> countryEntry=country.entrySet();
		Iterator<Entry<String, HashMap<String, Integer>>> countryIterator=countryEntry.iterator();
		while(countryIterator.hasNext()){
			String countryKey=countryIterator.next().getKey();
			System.out.println(countryKey);
			
				HashMap<String, Integer> countryValue=country.get(countryKey);
				Set<Entry<String, Integer>> hmEntry=countryValue.entrySet();
				Iterator<Entry<String, Integer>> hmIterator=hmEntry.iterator();
				while(hmIterator.hasNext()){
					String hmKey=hmIterator.next().getKey();
					Integer hmValue=countryValue.get(hmKey);
					System.out.println("\t"+hmKey+", "+hmValue);
				}
			
		}
		
	}

}
