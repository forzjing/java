package javaSe;

import java.util.ArrayList;
import java.util.Collection;

public class Collection_ArrayList {
	/*
	 * ���͸߼�(ͨ���)
	 * ?:�������ͣ����û����ȷ����ô����Object�Լ������Java����
	 * ? extends E:�����޶���E��������
	 * ? super E:�����޶���E���丸��
	 */
	public static void main(String[] args) {
		Collection<Object> c1 = new ArrayList<Object>();
		// ?��ʾ��������Ͷ��ǿ��Ե�
				Collection<?> c5 = new ArrayList<Object>();
				Collection<?> c6 = new ArrayList<Animal>();
				Collection<?> c7 = new ArrayList<Dog>();
				Collection<?> c8 = new ArrayList<Cat>();
				
				// ? extends E:�����޶���E��������
				// Collection<? extends Animal> c9 = new ArrayList<Object>();
				Collection<? extends Animal> c10 = new ArrayList<Animal>();
				Collection<? extends Animal> c11 = new ArrayList<Dog>();
				Collection<? extends Animal> c12 = new ArrayList<Cat>();

				// ? super E:�����޶���E���丸��
				Collection<? super Animal> c13 = new ArrayList<Object>();
				Collection<? super Animal> c14 = new ArrayList<Animal>();
				// Collection<? super Animal> c15 = new ArrayList<Dog>();
				// Collection<? super Animal> c16 = new ArrayList<Cat>();
	}

}
