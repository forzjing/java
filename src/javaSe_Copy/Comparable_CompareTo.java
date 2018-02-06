package javaSe_Copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class Diy implements Comparable<Diy>{
	String string;
	int num;
	public int compareTo(Diy d){
		int value=this.string.compareTo(d.string); //�ֵ�˳��Ƚ�string
		return (value==0) ? this.num-d.num:	 value ;	//������ͬ�򷵻����ֵıȽ�ֵ  //string��ͬ�Ƚ�num
			//valueΪ0�򷵻�this.num-d.num  ��Ϊ0����value
	}
	
	public Diy() {
		super();
	}

	public Diy(String string, int num) {
		super();
		this.string = string;
		this.num = num;
	}

	@Override
	public String toString() {
		return " [string=" + string + ", num=" + num + "]";
	}
	
	
}
public class Comparable_CompareTo {
	public static void main(String[] args) {
		//diyʵ����comparable�Ѿ�������treeset������Ȼ����
		TreeSet<Diy> treeSet=new TreeSet<>();
		treeSet.add(new Diy("jack",22));
		treeSet.add(new Diy("jack",11));
		treeSet.add(new Diy("hadle",22));
		treeSet.add(new Diy("imare",10));
		//System.out.println(treeSet);
		//treeSet �����ظ� ����ȫ �ٶȿ�
		for (Diy diy : treeSet) {
			System.out.println(diy);
		}
		System.out.println("ArrayListû���� ,�ظ��������±�");
		List<Diy> list=new ArrayList<Diy>();
		list.add(new Diy("jack",22));
		list.add(new Diy("adam",92));
		list.add(new Diy("jack",22));
		list.add(new Diy("adam",32));
		list.add(new Diy("adam",32));
		list.add(new Diy("hijk",52));
		for (Diy value : list) {
			System.out.println(value);
		}
		System.out.println("ArrayList ����������");
		list=new ArrayList<Diy>();
		list.add(new Diy("jack",22));
		list.add(new Diy("adam",92));
		list.add(new Diy("cack",22));
		list.add(new Diy("hijk",22));
		list.add(new Diy("back",22));
		list.add(new Diy("adam",22));
		list.add(new Diy("adam",32));
		list.add(new Diy("hijk",52));
		Collections.sort(list);
		for (Diy value : list) {
			System.out.println(value);
		}
		System.out.println("�Ƚ��� reverse order");
		Comparator<Diy> reverseOrder = Collections.reverseOrder();
		//��̬���� reverseOrder() 
		//����һ���Ƚ�������ǿ����תʵ���� Comparable �ӿڵĶ���ļ��ϵ���Ȼ˳�� 
		Collections.sort(list, reverseOrder);
		for (Diy value : list) {
			System.out.println(value);
		}
		//System.out.println("reversed");
		//Collections.reverse(list);
		//System.out.println(list);
		System.out.println("�Զ���comparator����");
		Collections.sort(list, new Comparator<Diy>() {
			@Override
			public int compare(Diy o1, Diy o2) {
				int value=o1.num-o2.num;
				return value==0? o1.string.compareTo(o2.string) : value;
			}
		});
		for (Diy value : list) {
			System.out.println(value);
		}
	}
}
