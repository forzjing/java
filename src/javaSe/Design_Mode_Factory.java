package javaSe;

abstract class Animal {
	public abstract void eat();
}

class Dog extends Animal {
	public void eat() {
		System.out.println("dog eat");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("cat eat");
	}
}
public class Design_Mode_Factory {
	
	public static void main(String[] args) {
		// Factory
		Factory.creatCat();
		Factory.creatDog();
	}
}
class Factory {
	Factory() {
	}
	
	private static Dog d = new Dog();
	private static Cat c = new Cat();

	public static Cat creatCat() {
		return c;
	}
	public static Dog creatDog() {
		return d;
	}
}

