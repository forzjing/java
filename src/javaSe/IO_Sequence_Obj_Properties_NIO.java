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

		
		
		
		// �ɱ�����ϲ��ļ�
		multiplicationAddFile(file, file2);
		
		
		
		

		// ���л�����
		objWrite();
		objRead();*/
		
		
		
		
		
		
		/* NIO
		 * Path:·��
		 * Paths:��һ����̬��������һ��·��
		 * 		public static Path get(URI uri)
		 * Files:�ṩ�˾�̬����������ʹ��
		 * 		public static long copy(Path source,OutputStream out):�����ļ�
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
	
		
		
		
		
		/*//properties û�з��Ͷ���String
		propertiesDemo();
		propertiesDemo1();
 
		
		
		PropertiesDemo3 pd3=new PropertiesDemo3();
		PropertiesDemo2 pd2=new PropertiesDemo2();
		*/
	
		
	}

	
	
	
	
	// SequenceInputStream(InputStream s1, InputStream s2)
	// ���󣺰�ByteArrayStreamDemo.java��DataStreamDemo.java�����ݸ��Ƶ�Copy.java��
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
	// ���󣺰�����������ļ������ݸ��Ƶ�Copy.java��
	// ByteArrayStreamDemo.java,CopyFileDemo.java,DataStreamDemo.java

	// SequenceInputStream(Enumeration e)
	// ͨ���򵥵Ļع�����֪����Enumeration��Vector�е�һ�������ķ���ֵ���͡�
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
	 * NotSerializableException:δ���л��쳣
	 * 
	 * ��ͨ��ʵ�� java.io.Serializable �ӿ������������л����ܡ�δʵ�ִ˽ӿڵ��ཫ�޷�ʹ���κ�״̬���л������л���
	 * �ýӿھ�Ȼû���κη���������������û�з����Ľӿڱ���Ϊ��ǽӿڡ�
	 * 
	 * java.io.InvalidClassException: cn.itcast_07.Person; local class
	 * incompatible: stream classdesc serialVersionUID = -2071565876962058344,
	 * local class serialVersionUID = -8345153069362641443
	 * 
	 * Ϊʲô����������? Person��ʵ�������л��ӿڣ���ô������ҲӦ����һ�����ֵ�� ������ֵ������100�� ��ʼ��ʱ��
	 * Person.class -- id=100 wirte���ݣ� oos.txt -- id=100 read����: oos.txt --
	 * id=100
	 * 
	 * ���ڣ� Person.class -- id=200 wirte���ݣ� oos.txt -- id=100 read����: oos.txt --
	 * id=100 ������ʵ�ʿ����У����ܻ���Ҫʹ����ǰд�������ݣ���������д�롣��ô����? ����һ��ԭ������Ϊ���ǵ�idֵ��ƥ�䡣
	 * ÿ���޸�java�ļ������ݵ�ʱ��,class�ļ���idֵ���ᷢ���ı䡣 ����ȡ�ļ���ʱ�򣬻��class�ļ��е�idֵ����ƥ�䡣���ԣ��ͻ�����⡣
	 * �����أ�������а취�������idֵ��java�ļ�����һ���̶���ֵ�����������޸��ļ���ʱ�����idֵ���ᷢ���ı���?
	 * ���ᡣ���ڵĹؼ���������ܹ�֪�����idֵ��α�ʾ����? ���õ��ģ��㲻�ü�ס��Ҳû��ϵ�������꼴�ɡ� ���ѵ�û�п�����ɫ��������?
	 * 
	 * ����Ҫ֪�����ǣ� ������ʵ�������л��ӿڵ�ʱ��Ҫ������ɫ���������⣬�Ϳ����Զ�����һ�����л�idֵ��
	 * ���Ҳ������ֵ�Ժ����Ƕ�������κθĶ�������ȡ��ǰ��������û������ġ�
	 * 
	 * ע�⣺ ��һ�����п����кܶ�ĳ�Ա��������Щ�Ҳ���������л������ʸ���ô����? ʹ��transient�ؼ�����������Ҫ���л��ĳ�Ա����
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
	
	//Properties���಻��һ��������,��ʹ�õ�ʱ��Ͳ��ܼӷ���
	// Properties<String, String> prop = new Properties<String, String>();
	//�ɱ��������л�����м��ء������б���ÿ���������Ӧֵ����һ���ַ����� 
	
	private static void propertiesDemo() {
		Properties prop = new Properties();
		prop.put("username", "hello");
		prop.put("times", "122");
		prop.put("password", "java");

		prop.setProperty("����", "30");
		prop.setProperty("����", "40");
		prop.setProperty("����", "50");
		// public Set<String> stringPropertyNames():��ȡ���еļ��ļ���
		Set<String> set1 = prop.stringPropertyNames();
		for (String key : set1) {
			String value = prop.getProperty(key);
			System.out.println(key + "---" + value);
		}
		
		// System.out.println("prop:" + prop);

		// ��������
		Set<Object> set = prop.keySet();
		for (Object key : set) {
			Object value = prop.get(key);
			System.out.println(key + "---" + value);
		}
	}
	
	private static void propertiesDemo1() throws IOException{
		// ���ļ��е����ݼ��ص�������
		Properties prop = new Properties();
		Reader r = new FileReader("user.txt");
		prop.load(r);
		r.close();

		// �������ϣ���ȡ�õ�ÿһ����
		Set<String> set = prop.stringPropertyNames();
		for (String key : set) {
			// �жϼ��Ƿ���Ϊ"lisi"�ģ�����о��޸���ֵΪ"100"
			if ("lisi".equals(key)) {
				prop.setProperty(key, "100");
				break;
			}
		}

		// �Ѽ����е��������´洢���ļ���
		Writer w = new FileWriter("user.txt");
		prop.store(w, null);
		w.close();
	}
}

class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		// ����һ�������
		int number = (int) (Math.random() * 100) + 1;

		// ����һ��ͳ�Ʊ���
		int count = 0;

		while (true) {
			// ����¼��һ������
			Scanner sc = new Scanner(System.in);
			System.out.println("����������(1-100)��");
			int guessNumber = sc.nextInt();

			count++;

			// �ж�
			if (guessNumber > number) {
				System.out.println("��µ�����" + guessNumber + "����");
			} else if (guessNumber < number) {
				System.out.println("��µ�����" + guessNumber + "С��");
			} else {
				System.out.println("��ϲ�㣬" + count + "�ξͲ�����");
				break;
			}
		}
	}
}
/*
 * ����ļ��ϱ�����Properties���ϣ�
 * public void load(Reader reader):���ļ��е����ݶ�ȡ��������
 * public void store(Writer writer,String comments):�Ѽ����е����ݴ洢���ļ�
 * 
 * ��������Ϸ��
 * 		���ȱ���ͼ��ء�
 * 		����ȺӢ��������־���ɽ�������...
 * 
 * 		����=1
 * 		���컭�=1
 */

class PropertiesDemo3 {
	public static void main(String[] args) throws IOException {
		// myLoad();

		myStore();
	}

	private static void myStore() throws IOException {
		// �������϶���
		Properties prop = new Properties();

		prop.setProperty("����ϼ", "27");
		prop.setProperty("����", "30");
		prop.setProperty("������", "18");
		
		//public void store(Writer writer,String comments):�Ѽ����е����ݴ洢���ļ�
		Writer w = new FileWriter("name.txt");
		prop.store(w, "helloworld");
		w.close();
	}

	private static void myLoad() throws IOException {
		Properties prop = new Properties();

		// public void load(Reader reader):���ļ��е����ݶ�ȡ��������
		// ע�⣺����ļ������ݱ����Ǽ�ֵ����ʽ
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
 * ����һ��������С��Ϸ�ĳ�����дһ������ʵ���ڲ�������ֻ����5�Σ�����5����ʾ����Ϸ�����ѽ������븶�ѡ�
 */
class PropertiesDemo2 {
	public static void main(String[] args) throws IOException {
		// ��ȡĳ���ط������ݣ��������������5�����Լ����档�������ʾ"��Ϸ�����ѽ������븶�ѡ�"
		// ����һ���ļ�
		// File file = new File("count.txt");
		// if (!file.exists()) {
		// file.createNewFile();
		// }

		// �����ݼ��ص�������
		Properties prop = new Properties();
		Reader r = new FileReader("count.txt");
		prop.load(r);
		r.close();

		// ���Լ��ĳ����ҵ�Ȼ֪������ļ���˭
		String value = prop.getProperty("count");
		int number = Integer.parseInt(value);

		if (number > 5) {
			System.out.println("��Ϸ�����ѽ������븶�ѡ�");
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





