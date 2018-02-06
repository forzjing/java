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
		int value=this.string.compareTo(d.string); //字典顺序比较string
		return (value==0) ? this.num-d.num:	 value ;	//名字相同则返回数字的比较值  //string相同比较num
			//value为0则返回this.num-d.num  不为0返回value
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
		//diy实现了comparable已经可以在treeset里面自然排序
		TreeSet<Diy> treeSet=new TreeSet<>();
		treeSet.add(new Diy("jack",22));
		treeSet.add(new Diy("jack",11));
		treeSet.add(new Diy("hadle",22));
		treeSet.add(new Diy("imare",10));
		//System.out.println(treeSet);
		//treeSet 有序不重复 不安全 速度快
		for (Diy diy : treeSet) {
			System.out.println(diy);
		}
		System.out.println("ArrayList没排序 ,重复有序有下标");
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
		System.out.println("ArrayList 工具类排序");
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
		System.out.println("比较器 reverse order");
		Comparator<Diy> reverseOrder = Collections.reverseOrder();
		//静态方法 reverseOrder() 
		//返回一个比较器，它强行逆转实现了 Comparable 接口的对象的集合的自然顺序。 
		Collections.sort(list, reverseOrder);
		for (Diy value : list) {
			System.out.println(value);
		}
		//System.out.println("reversed");
		//Collections.reverse(list);
		//System.out.println(list);
		System.out.println("自定义comparator排序");
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
