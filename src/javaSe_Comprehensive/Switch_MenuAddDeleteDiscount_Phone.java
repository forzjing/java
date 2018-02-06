package javaSe_Comprehensive;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Switch_MenuAddDeleteDiscount_Phone {

	public static ArrayList<Phone> list = new ArrayList<>();
	static {
		Phone p1 = new Phone("huawei", "tallcat", 2300, new Date(), 12);
		Phone p2 = new Phone("apple", "amazon", 4000, new Date(), 22);
		Phone p3 = new Phone("vivi", "vipin", 3000, new Date(), 55);
		Phone p4 = new Phone("susing", "jingdo", 4000, new Date(), 33);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
	}

	public static void main(String[] args) {
		showItem(list);
		// System.out.println("0.show 1.add 2.zekou 4.delete 3.exit");
		while (true) {
			int i = choose();
			switch (i) {
			case 0:
				showItem(list);
				break;
			case 1:
				add(list);
				break;
			case 2:
				daZhe(list);
				break;
			case 3:
				System.out.println("thanks exit");
				System.exit(0);
			case 4:
				delete(list);
				break;
			default:
				System.out.println("wrong");
				break;
			}
		}
	}

	public static void showItem(ArrayList<Phone> list) {
		System.out.println("Goods\t" + "seller\t" + "price\t" + "date\t" + "\t\tNo.\t");
		for (int i = 0; i < list.size(); i++) {
			Phone phone = list.get(i);
			System.out.println(phone.getName() + "\t" + phone.getSell() + "\t" + phone.getPrice() + "\t"
					+ phone.getDate() + "\t" + phone.getNum());
		}
	}

	public static int choose() {
		System.out.println("0.show   1.add      2.zekou    4.delete  3.exit");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		return i;
	}

	public static void add(ArrayList<Phone> lsit) {
		Scanner sc = new Scanner(System.in);
		Phone p = new Phone();
		System.out.println("input phone name");
		p.setName(sc.next());
		System.out.println("input phone seller");
		p.setSell(sc.next());
		System.out.println("input phone price");
		p.setPrice(Double.valueOf(sc.next()));
		p.setDate(new Date());
		System.out.println("input phone No.of.");
		p.setNum(sc.nextInt());
		list.add(p);
		System.out.println("ok");
		showItem(list);
	}

	public static void delete(ArrayList<Phone> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input phone name");
		String name = sc.next();
		for (int i = 0; i < list.size(); i++) {
			Phone phone = list.get(i);
			if (name.equals(phone.getName())) {
				list.remove(i);
				showItem(list);
				return;
			}
		}
		System.out.println("delete fail");
	}

	public static void daZhe(ArrayList<Phone> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input ..dazhe");
		Double num = sc.nextDouble();
		for (int i = 0; i < list.size(); i++) {
			Phone phone = list.get(i);
			long round = Math.round(phone.getPrice() * num / 10.0);
			phone.setPrice(round);
		}
		showItem(list);
	}

	public static void exit() {

	}
}

class Phone {
	private String name;
	private String sell;
	private double price;
	private Date date;
	private int num;

	public Phone() {
		super();
	}

	public Phone(String name, String sell, double price, Date date, int num) {
		super();
		this.name = name;
		this.sell = sell;
		this.price = price;
		this.date = date;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this.date);
	}

	public void setDate(Date date) {

		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}