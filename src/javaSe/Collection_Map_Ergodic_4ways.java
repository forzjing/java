package javaSe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Collection_Map_Ergodic_4ways {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("david", 22);
		map.put("adam", 40);
		map.put("lucy", 33);
		Collection<Integer> c = map.values();// ��ȡvalue����
		Set<String> key = map.keySet(); // ��ȡkey����
		// ��һ�� ��������keySet
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String keyString = it.next();
			Integer valueInt = map.get(keyString);
			System.out.println(keyString + "\t" + valueInt);
		}
		// ��һ�� keySet+ foreach
		for (String keyString : keySet) {
			Integer valueInt = map.get(keyString);
			System.out.println(keyString + "\t" + valueInt);
		}
		// �ڶ��� + foreach���ü�ֵ�Թ�ϵ ;
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIt = entrySet.iterator();
		while (entryIt.hasNext()) {
			Entry<String, Integer> keyValue = entryIt.next();
			String keyString = keyValue.getKey();
			Integer valueInt = keyValue.getValue();
			System.out.println(keyString + "\t" + valueInt);
		}
		// �ڶ��� + foreach���ü�ֵ�Թ�ϵ ;
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry);
		}
	}
}
