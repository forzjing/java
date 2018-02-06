package javaSe_Comprehensive;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Login_Input_Write_Bike_Date {

	public static void main(String[] args) throws IOException {
		// login
		TreeSet<Bike> ts = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat();

		Map<String, String> tMap = new TreeMap<String, String>();
		tMap.put("aaa", "1111");
		tMap.put("bbb", "2222");
		System.out.println("username");
		String name = sc.next();
		System.out.println("password");
		String pass = sc.next();

		Set<String> keys = tMap.keySet();
		if (keys.contains(name) && pass.equals(tMap.get(name))) {
			System.out.println("login success");
		} else {
			System.out.println("exit");
			return;
		}

		// input
		do {
			Bike b = new Bike();
			System.out.println("brand");
			b.setBrand(sc.next());
			System.out.println("price");
			b.setPrice(Integer.valueOf(sc.next()));
			Date d = new Date();
			b.setDate(sdf.format(d).toString());
			ts.add(b);
			if (ts.size() > 3) {
				System.out.println("Y continue N exit");
				String s = sc.next();
				if (s.equalsIgnoreCase("y")) {
					continue;
				} else if (s.equalsIgnoreCase("n")) {
					break;
				}
			}
		} while (true);
			System.out.println("name\t"+"price\t"+"date");
			for (Bike bike : ts) {
				System.out.println(bike);
			}
			
			BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
			for (Bike bike : ts) {
				bw.write(bike.toString());
				bw.newLine();
				bw.flush();
			}
			bw.close();
	}

}

class Bike implements Comparable<Bike> {
	String brand;
	int price;
	String date;

	@Override
	public int compareTo(Bike o) {
		int num= o.price-this.price;
		int num2=  num==0? o.brand.compareToIgnoreCase(brand):num;
		int num3=  num2==0?  o.date.compareTo(date): num2;
		return num3;
	}

	public Bike(String brand, int price, String date) {
		super();
		this.brand = brand;
		this.price = price;
		this.date = date;
	}

	public Bike() {
		super();
	}

	@Override
	public String toString() {
		return brand + "\t" + price + "\t" + date;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

}