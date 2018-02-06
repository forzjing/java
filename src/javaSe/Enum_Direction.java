package javaSe;

public class Enum_Direction {

	public static void main(String[] args) {
		Direction d=Direction.FRONT;
		d.show();
		System.out.println(d);		//toString ��д�󷵻�ö�ٳ�������FRONT
		System.out.println(d.getName()); 
		System.out.println(d.name());
		System.out.println(d.name);   
		System.out.println("----------");
		d=Direction.BEHIND;
		d.show();
		System.out.println(d);		//toString ��д�󷵻�ö�ٳ�������FRONT
		System.out.println(d.getName()); 
		System.out.println(d.name());
		System.out.println(d.name); 
		System.out.println("----------");

		switch (d) {
		case FRONT:
			System.out.println("��ѡ����ǰ");
			break;
		case BEHIND:
			System.out.println("��ѡ���˺�");
			break;
		case LEFT:
			System.out.println("��ѡ������");
			break;
		case RIGHT:
			System.out.println("��ѡ������");
			break;
		}
		
		Direction d1=Direction.FRONT;
		Direction d2=Direction.BEHIND;
		Direction d3=Direction.LEFT;
		Direction d4=Direction.RIGHT;
		System.out.println(d1.compareTo(d1));
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.compareTo(d3));   //compareTo
		System.out.println(d1.compareTo(d4));
		System.out.println("----------------");
		System.out.println(d1.name());  //String name();
		System.out.println(d2.name()); 
		System.out.println(d3.name()); 
		System.out.println(d4.name()); 
		System.out.println("----------------");	
		System.out.println(d1.ordinal()); 	// int ordinal()
		System.out.println(d2.ordinal());
		System.out.println(d3.ordinal());
		System.out.println(d4.ordinal());
		System.out.println("----------------");	
		System.out.println(d1.toString());// String toString()
		System.out.println(d2.toString());
		System.out.println(d3.toString());
		System.out.println(d4.toString());
		System.out.println("--------------");
		
	// <T> T valueOf(Class<T> type,String name)
			d = Enum.valueOf(Direction.class, "FRONT");
			System.out.println(d.getName());
			System.out.println("----------------");
			// values()
			// �˷�����Ȼ��JDK�ĵ��в��Ҳ�������ÿ��ö���඼���и÷�����������ö���������ö��ֵ�ǳ�����
			Direction [] dir = Direction.values();
			for (Direction value : dir) {
				System.out.println(value);
				System.out.println(value.getName());
			}
		
	}

}

enum Direction {
	FRONT {
		@Override
		public void show() {
			System.out.println("FRONT show");
		}
	},
	BEHIND("behind") {

		@Override
		public void show() {
			System.out.println("BEHIND show");
		}

	},
	LEFT {
		@Override
		public void show() {
			System.out.println("LEFT show");
		}
	},
	RIGHT("right") {
		@Override
		public void show() {
			System.out.println("RIGHT show");
		}
	};
	/*
	 * public static final Direction FRONT= new Direction(); 
	 * public static final Direction BEHIND= new Direction(String name); 
	 * public static final Direction LEFT= new Direction(); 
	 * public static final Direction RIGHT= new Direction(String name);
	 */
	public String name;

	private Direction() { //ֻ��˽��
	}

	private Direction(String name) {  //ֻ����˽��
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void show();

}