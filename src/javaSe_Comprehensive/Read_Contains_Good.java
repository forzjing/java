package javaSe_Comprehensive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Read_Contains_Good {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("a.txt"));
		ArrayList<String>   list=new ArrayList();
		String s=null;
		int a=0;
		int b=0;
		while(  (s=br.readLine())  !=  null) {
			list.add(s);
			if(s.contains("piano")) {
				a++;
			}else if(s.contains("compute")) {
				b++;
			}
		}
		for (String line : list) {
			System.out.println(line);
		}
		System.out.println("piano"+"\t"+a);
		System.out.println("compute"+"\t"+b);
		br.close();
		TreeSet<Good> tSet=new TreeSet<>();
		String regex="	";
		for (String line : list) {
			String[]  stringArray=line.split(regex);
			Good good=new Good(stringArray[0],Double.valueOf(stringArray[1]),stringArray[2]);
			tSet.add(good);
		}
		System.out.println("name\t"+"price\t"+"kind");
		for (Good good : tSet) {
			System.out.println(good);
		}
	}

}

class Good implements Comparable<Good>{
	private String name;
	private double price;
	private String kind;
	public Good(String name, double price, String kind) {
		super();
		this.name = name;
		this.price = price;
		this.kind = kind;
	}
	public Good() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public int compareTo(Good o) {
		int num=(int) (this.price-o.price);
		return  num==0? this.name.compareTo(o.name) :num;
	}
	@Override
	public String toString() {
		return name + "\t" + price + "\t" + kind ;
	}
	
	
}