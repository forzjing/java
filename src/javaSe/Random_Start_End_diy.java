package javaSe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Random_Start_End_diy {

	public static void main(String[] args) {
		// 自定义范围的随机数
		System.out.println(getString());
		for (int x = 0; x < 20; x++) {
			System.out.print(get(0, 5) + ", ");
		}
		System.out.println("\r");
		// 不重复随机数
		Random r = new Random();
		HashSet<Integer> hSet = new HashSet<>();
		while (hSet.size() < 10) {
			hSet.add(r.nextInt(20) + 1);
		}
		System.out.println(hSet.toString());
		// 不重复随机数ArrayList
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		while (count < 10) {
			Integer value = (int) (Math.random() * 10 + 1); // 1-10
			if (!list.contains(value)) {
				list.add(value);
				count++;
			}
		}
		System.out.println(list);
	}

	private static int get(int start, int end) { // 自定义范围的随机数
		return (int) (Math.random() * (end - start + 1)) + start;
	}
	public static String getString(){
		char[] cha=new char[5];
		for (int x=0;x<cha.length;x++) {
			cha[x]=(char)((byte)(Math.random()*(90-65+1)+65) );
		}
		return String.valueOf(cha);
	}	
	

}
