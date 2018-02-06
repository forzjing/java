package javaSe_Comprehensive;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Map_Write_Car {

	public static void main(String[] args) throws IOException {
		Map<Car, Integer> map = new TreeMap<>();
		Car c1 = new Car("audo", 100);
		Car c2 = new Car("polo", 200);
		Car c3 = new Car("penchi", 300);
		map.put(c1, 20000);
		map.put(c2, 500000);
		map.put(c3, 3000000);
		BufferedWriter bw = new BufferedWriter(new FileWriter("Car.txt"));
		//Set<Map.Entry<Car, Integer>> entry = map.entrySet();
		bw.write("brand" + "\t" + "speed" + "\t" + "price" + "\r\n");
	
		//key+value  --- toString;
		/*for (Entry<Car, Integer> line : entry) {
			bw.write(line.toString());
			bw.newLine();
			bw.flush();
		}*/
		Set<Car> keySet = map.keySet();
		for (Car car : keySet) {
			Integer value=map.get(car);
			bw.write(car.getName()+"\t"+car.getSpeed()+"\t\t"+value);
			bw.newLine();
			bw.flush();
		}		
		bw.close();
	}
}

class Car implements Comparable<Car> {
	String name;
	int speed;

	@Override
	public int compareTo(Car o) {
		int num = o.speed - speed;
		int num1 = num == 0 ? o.name.compareTo(this.name) : num;
		return num1;
	}

	@Override
	public String toString() {
		return name + "\t" + speed;
	}

	public Car() {
		super();
	}

	public Car(String name, int speed) {
		super();
		this.name = name;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
