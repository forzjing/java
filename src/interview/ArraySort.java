package interview;

public class ArraySort {

	public static void main(String[] args) {
		
		/*
		 * 长度为n的线性表，最坏的情况下，各种排序方法的比较次数为多少
		 */
		Integer i=new Integer(42);
		Long l=new Long(42);
		Double d=new Double(42.0);
		System.out.println(i.equals(d));
		System.out.println(i.equals(42));
	System.out.println(i==l);
		//System.out.println(i==d);
		
		new java.util.HashMap<>().put(null, null);
		new java.util.TreeMap().put(0, null);
		/**
		 * 想想快速排序，每次都会选取线性表的轴值，随后以此轴值划分为两个子线性表再分别进行快排，
		 * 在最坏情况下，也就是说每次选出的线性表轴值完全不能将这个线性表划分为两个子线性表。
		 * 那么此时快速排序退化为冒泡排序了。 那么第一趟排序时，轴值（线性表的中间位置）被选出，
		 * 这个值绝对是这个线性表中最大的（不然也不能是最坏情况），其他值都比他小，
		 * 那么线性表现在分为完全不对等的两段（一段是0,另一段是n - 1），一段是这个值，一段是其他值。
		 * 同样第二趟排序在刚才剩下的值中选中间值（剩余值中最大的那个），又分为不对等两段，依次递推。
		 * 也就是说每次都比较了N - 1个元素（轴值选出后都与它比较大小），
		 * 那么肯定是比较了n - 1次（如第一次先挑了个轴值，然后剩下n - 1比较）,
		 * n代表当前子线性表中元素个数 由此最白痴的数列问题出现了，
		 * 如下 1 + 2 + 3 + .......... + n - 2 + n - 1 = n(n - 1) / 2 还有一种投机取巧的方法，
		 * 在最垃圾情况下既然快排变为冒泡，那由时间复杂度知其必为o(n ^ 2)的复杂度，
		 * 答案中ABC都是线性时间复杂，显然错误
		 */
	}
}
