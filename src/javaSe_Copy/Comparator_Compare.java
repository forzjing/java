package javaSe_Copy;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Diy1 implements Comparator<Diy1>{
	String string;
	int num;
	@Override
	public String toString() {
		return " [string=" + string + ", num=" + num + "]";
	}
	public Diy1(String string, int num) {
		super();
		this.string = string;
		this.num = num;
	}
	public Diy1() {
		super();
	}
	@Override
	public int compare(Diy1 o1, Diy1 o2) {
		int value= o1.num-o2.num;
		return  value==0 ? o1.string.compareTo(o2.string):value;
		//��ͬnum��Ƚ��ַ����Ⱥ�˳��
		/*
		 *compare�����Ǽ��ϵ��� 
		 *���ȥ�Ķ��󴫵ݸ�s1,�Ƚ�ȥ�Ĵ��ݸ�s2
		 */
	}
}
		//Comparatorֻ������ �����򼯺�treeSet treeMap
public class Comparator_Compare {
	public static void main(String[] args) {
		Diy1 d=new Diy1();
		TreeSet<Diy1> treeSet=new TreeSet<>(d);//���ݱȽ��� dΪcomparator��ʵ����
		treeSet.add(new Diy1("aaaa", 1));
		treeSet.add(new Diy1("yyyy", 5));
		treeSet.add(new Diy1("xxxx", 3));
		treeSet.add(new Diy1("zzzz", 2));
		treeSet.add(new Diy1("bbbb", 1));
		//System.out.println(treeSet);
		for (Diy1 diy : treeSet) {
			System.out.println(diy+"  , ");
		}
		System.out.println("\r");
		Map<Diy1, String> map=new TreeMap<>(new Diy1());  //���ݱȽ���
		map.put(new Diy1("adam",2), "USA");
		map.put(new Diy1("bily",2), "JAPA");
		map.put(new Diy1("cdam",23), "USA");
		map.put(new Diy1("adam",2), "USA"); //���ظ�
		map.put(new Diy1("dsss",4), "CHINA");
		Set<Entry<Diy1, String>> entrySet = map.entrySet();
		for (Entry<Diy1, String> entry : entrySet) {
			Diy1 key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+" "+value);
		}
	
	/*	Collections.sort(treeSet, new Comparator<Diy1>() {
			public int compare(Diy1 o1, Diy1 o2) {
				int value=o1.string.compareTo(o2.string);
			return  value==0 ?  o1.num-o2.num:value;
			};
		} );*/
	}
}
