package javaSe;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class IO_Sequence_Obj_Properties_NIO {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		
		
		/*
		File file = new File("a.txt");
		File file2 = new File("b.txt");
		addFile(file, file2);

		
		
		
		// 可变参数合并文件
		multiplicationAddFile(file, file2);
		
		
		
		

		// 序列化对象
		objWrite();
		objRead();*/
		
		
		
		
		
		
		/* NIO
		 * Path:路径
		 * Paths:有一个静态方法返回一个路径
		 * 		public static Path get(URI uri)
		 * Files:提供了静态方法供我们使用
		 * 		public static long copy(Path source,OutputStream out):复制文件
		 * 		public static Path write(Path path,Iterable<? extends CharSequence> lines,Charset cs,OpenOption... options)
		 */
		ArrayList<String> array=new ArrayList<String>();
		// public static long copy(Path source,OutputStream out)
		// Files.copy(Paths.get("ByteArrayStreamDemo.java"), new
		// FileOutputStream(
		// "Copy.java"));
		array.add("hello");
		array.add("world");
		array.add("java");
		Files.write(Paths.get("array.txt"),array,Charset.forName("GBK"));
	
		
		
		
		
		/*//properties 没有泛型都是String
		propertiesDemo();
		propertiesDemo1();
 
		
		
		PropertiesDemo3 pd3=new PropertiesDemo3();
		PropertiesDemo2 pd2=new PropertiesDemo2();
		*/
	
		
	}

	
	
	
	
	// SequenceInputStream(InputStream s1, InputStream s2)
	// 需求：把ByteArrayStreamDemo.java和DataStreamDemo.java的内容复制到Copy.java中
	private static void addFile(File file1, File file2) throws IOException {
		InputStream is1 = new FileInputStream(file1);
		InputStream is2 = new FileInputStream(file2);
		SequenceInputStream sis = new SequenceInputStream(is1, is2);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("target.txt"));

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = sis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}
		bos.close();
		sis.close();
	}
	// 需求：把下面的三个文件的内容复制到Copy.java中
	// ByteArrayStreamDemo.java,CopyFileDemo.java,DataStreamDemo.java

	// SequenceInputStream(Enumeration e)
	// 通过简单的回顾我们知道了Enumeration是Vector中的一个方法的返回值类型。
	// Enumeration<E> elements()
	private static void multiplicationAddFile(File... file) throws IOException {
		Vector<InputStream> v = new Vector<InputStream>();
		for (File f : file) {
			InputStream s = new FileInputStream(f);
			v.add(s);
		}
		Enumeration<InputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("target.txt"));
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = sis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}
		bos.close();
		sis.close();
	}

	/*
	 * NotSerializableException:未序列化异常
	 * 
	 * 类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
	 * 该接口居然没有任何方法，类似于这种没有方法的接口被称为标记接口。
	 * 
	 * java.io.InvalidClassException: cn.itcast_07.Person; local class
	 * incompatible: stream classdesc serialVersionUID = -2071565876962058344,
	 * local class serialVersionUID = -8345153069362641443
	 * 
	 * 为什么会有问题呢? Person类实现了序列化接口，那么它本身也应该有一个标记值。 这个标记值假设是100。 开始的时候：
	 * Person.class -- id=100 wirte数据： oos.txt -- id=100 read数据: oos.txt --
	 * id=100
	 * 
	 * 现在： Person.class -- id=200 wirte数据： oos.txt -- id=100 read数据: oos.txt --
	 * id=100 我们在实际开发中，可能还需要使用以前写过的数据，不能重新写入。怎么办呢? 回想一下原因是因为它们的id值不匹配。
	 * 每次修改java文件的内容的时候,class文件的id值都会发生改变。 而读取文件的时候，会和class文件中的id值进行匹配。所以，就会出问题。
	 * 但是呢，如果我有办法，让这个id值在java文件中是一个固定的值，这样，你修改文件的时候，这个id值还会发生改变吗?
	 * 不会。现在的关键是我如何能够知道这个id值如何表示的呢? 不用担心，你不用记住，也没关系，点击鼠标即可。 你难道没有看到黄色警告线吗?
	 * 
	 * 我们要知道的是： 看到类实现了序列化接口的时候，要想解决黄色警告线问题，就可以自动产生一个序列化id值。
	 * 而且产生这个值以后，我们对类进行任何改动，它读取以前的数据是没有问题的。
	 * 
	 * 注意： 我一个类中可能有很多的成员变量，有些我不想进行序列化。请问该怎么办呢? 使用transient关键字声明不需要序列化的成员变量
	 */
	private static void objRead() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("oops.txt"));
		Object obj = ois.readObject();
		ois.close();
		System.out.println(obj);
	}

	private static void objWrite() throws IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));
		Person p = new Person("adam", 22);
		oos.writeObject(p);
		oos.close();
	}
	
	//Properties该类不是一个泛型类,在使用的时候就不能加泛型
	// Properties<String, String> prop = new Properties<String, String>();
	//可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。 
	
	private static void propertiesDemo() {
		Properties prop = new Properties();
		prop.put("username", "hello");
		prop.put("times", "122");
		prop.put("password", "java");

		prop.setProperty("张三", "30");
		prop.setProperty("李四", "40");
		prop.setProperty("王五", "50");
		// public Set<String> stringPropertyNames():获取所有的键的集合
		Set<String> set1 = prop.stringPropertyNames();
		for (String key : set1) {
			String value = prop.getProperty(key);
			System.out.println(key + "---" + value);
		}
		
		// System.out.println("prop:" + prop);

		// 遍历集合
		Set<Object> set = prop.keySet();
		for (Object key : set) {
			Object value = prop.get(key);
			System.out.println(key + "---" + value);
		}
	}
	
	private static void propertiesDemo1() throws IOException{
		// 把文件中的数据加载到集合中
		Properties prop = new Properties();
		Reader r = new FileReader("user.txt");
		prop.load(r);
		r.close();

		// 遍历集合，获取得到每一个键
		Set<String> set = prop.stringPropertyNames();
		for (String key : set) {
			// 判断键是否有为"lisi"的，如果有就修改其值为"100"
			if ("lisi".equals(key)) {
				prop.setProperty(key, "100");
				break;
			}
		}

		// 把集合中的数据重新存储到文件中
		Writer w = new FileWriter("user.txt");
		prop.store(w, null);
		w.close();
	}
}

class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		// 产生一个随机数
		int number = (int) (Math.random() * 100) + 1;

		// 定义一个统计变量
		int count = 0;

		while (true) {
			// 键盘录入一个数据
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入数据(1-100)：");
			int guessNumber = sc.nextInt();

			count++;

			// 判断
			if (guessNumber > number) {
				System.out.println("你猜的数据" + guessNumber + "大了");
			} else if (guessNumber < number) {
				System.out.println("你猜的数据" + guessNumber + "小了");
			} else {
				System.out.println("恭喜你，" + count + "次就猜中了");
				break;
			}
		}
	}
}
/*
 * 这里的集合必须是Properties集合：
 * public void load(Reader reader):把文件中的数据读取到集合中
 * public void store(Writer writer,String comments):把集合中的数据存储到文件
 * 
 * 单机版游戏：
 * 		进度保存和加载。
 * 		三国群英传，三国志，仙剑奇侠传...
 * 
 * 		吕布=1
 * 		方天画戟=1
 */

class PropertiesDemo3 {
	public static void main(String[] args) throws IOException {
		// myLoad();

		myStore();
	}

	private static void myStore() throws IOException {
		// 创建集合对象
		Properties prop = new Properties();

		prop.setProperty("林青霞", "27");
		prop.setProperty("武鑫", "30");
		prop.setProperty("刘晓曲", "18");
		
		//public void store(Writer writer,String comments):把集合中的数据存储到文件
		Writer w = new FileWriter("name.txt");
		prop.store(w, "helloworld");
		w.close();
	}

	private static void myLoad() throws IOException {
		Properties prop = new Properties();

		// public void load(Reader reader):把文件中的数据读取到集合中
		// 注意：这个文件的数据必须是键值对形式
		Reader r = new FileReader("prop.txt");
		prop.load(r);
		r.close();

		System.out.println("prop:" + prop);
	}
}



class Person implements Serializable {
	private static final long seriatversionUID = -516546434646464984L;
	private String name;
	private transient int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}


/*
 * 我有一个猜数字小游戏的程序，请写一个程序实现在测试类中只能用5次，超过5次提示：游戏试玩已结束，请付费。
 */
class PropertiesDemo2 {
	public static void main(String[] args) throws IOException {
		// 读取某个地方的数据，如果次数不大于5，可以继续玩。否则就提示"游戏试玩已结束，请付费。"
		// 创建一个文件
		// File file = new File("count.txt");
		// if (!file.exists()) {
		// file.createNewFile();
		// }

		// 把数据加载到集合中
		Properties prop = new Properties();
		Reader r = new FileReader("count.txt");
		prop.load(r);
		r.close();

		// 我自己的程序，我当然知道里面的键是谁
		String value = prop.getProperty("count");
		int number = Integer.parseInt(value);

		if (number > 5) {
			System.out.println("游戏试玩已结束，请付费。");
			System.exit(0);
		} else {
			number++;
			prop.setProperty("count", String.valueOf(number));
			Writer w = new FileWriter("count.txt");
			prop.store(w, null);
			w.close();

			GuessNumber.start();
		}
	}
}





