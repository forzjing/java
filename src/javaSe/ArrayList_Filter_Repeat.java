package javaSe;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_Filter_Repeat {

	public static void main(String[] args) {

		ArrayList<String> aList = new ArrayList<>();
		aList.add("00000000");
		aList.add("ssssssss");
		aList.add("11111111");
		aList.add("00000000");
		aList.add("ssssssss");
		aList.add("11111111");
		// 删除集合中重复元素 //1
		for (int x = 0; x < aList.size() - 1; x++) {
			for (int y = x + 1; y < aList.size(); y++) {
				if (aList.get(x).equals(aList.get(y))) {
					aList.remove(y);
					y--;
				}
			}
		}
		// 遍历
		Iterator<String> it = aList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// 2
		filterRepeat(aList);
	}
	//2
	private static ArrayList<String> filterRepeat(ArrayList<String> aList) {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> it = aList.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (!list.contains(s)) {
				list.add(s);
			}
		}
		return list;
	}

}
