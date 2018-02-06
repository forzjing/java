package javaSe_Copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Nesting_Map {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, ArrayList<Hashtable<String, String>>>> hMap=new HashMap<>();
		HashMap<String, ArrayList<Hashtable<String, String>>> banMap=new HashMap<>();
		
		ArrayList<Hashtable<String, String>> aList1=new ArrayList<>();
		ArrayList<Hashtable<String, String>> aList2=new ArrayList<>();
		Hashtable<String,String>  pTable=new Hashtable<>();
		pTable.put("adam", "33");
		pTable.put("jack", "25");
		
		Hashtable<String, String> jTable=new Hashtable<>();
		jTable.put("lily", "22");
		jTable.put("vivi", "33");
		aList1.add(pTable);
		aList2.add(jTable);
		
		banMap.put("basic", aList1);
		banMap.put("job", aList2);
		
		hMap.put("czbk", banMap);
		
		Set<Map.Entry<String, HashMap<String,  ArrayList<Hashtable<String, String>>>>> sethMap=hMap.entrySet();
		for (Map.Entry<String, HashMap<String,  ArrayList<Hashtable<String, String>>>> hEntry :sethMap) {
				
				System.out.println(hEntry.getKey());
			
				
				Set<String> setbMap=banMap.keySet();
				for (String banKey: setbMap) {
					ArrayList<Hashtable<String, String>> banValue = banMap.get(banKey);
					System.out.println("\t"+banKey);
					
					
					//aList
					for (Hashtable<String, String> aList : banValue) {
						Set<String> setKey=aList.keySet();
						for (String key : setKey) {
							String value= aList.get(key);
							System.out.println("\t"+ "\t"+key+"  "+value);
						}
					}
					/*//aList1
					for (Hashtable<String, String> hp1 : aList1) {
						//System.out.println(hp1);
					
							 Set<String> setpTable = pTable.keySet();
							for (String key : setpTable) {
								String value = pTable.get(key);
								System.out.println(key+"  "+value);
							}
					}
				 //aList2
					for (Hashtable<String, String> hp2 : aList2) {
					//	System.out.println(hp2);
						
						 Set<String> setpTable = jTable.keySet();
							for (String key : setpTable) {
								String value = jTable.get(key);
								System.out.println(key+"  "+value);
							}
						
						}*/
						
					}
			
		}
		
		
	}

}
