package javaSe;

import java.util.ArrayList;
import java.util.Collection;

public class Collection_ArrayList {
	/*
	 * 泛型高级(通配符)
	 * ?:任意类型，如果没有明确，那么就是Object以及任意的Java类了
	 * ? extends E:向下限定，E及其子类
	 * ? super E:向上限定，E极其父类
	 */
	public static void main(String[] args) {
		Collection<Object> c1 = new ArrayList<Object>();
		// ?表示任意的类型都是可以的
				Collection<?> c5 = new ArrayList<Object>();
				Collection<?> c6 = new ArrayList<Animal>();
				Collection<?> c7 = new ArrayList<Dog>();
				Collection<?> c8 = new ArrayList<Cat>();
				
				// ? extends E:向下限定，E及其子类
				// Collection<? extends Animal> c9 = new ArrayList<Object>();
				Collection<? extends Animal> c10 = new ArrayList<Animal>();
				Collection<? extends Animal> c11 = new ArrayList<Dog>();
				Collection<? extends Animal> c12 = new ArrayList<Cat>();

				// ? super E:向上限定，E极其父类
				Collection<? super Animal> c13 = new ArrayList<Object>();
				Collection<? super Animal> c14 = new ArrayList<Animal>();
				// Collection<? super Animal> c15 = new ArrayList<Dog>();
				// Collection<? super Animal> c16 = new ArrayList<Cat>();
	}

}
