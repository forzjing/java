package javaSe;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.TreeSet;

public class Refect_Apply_Reader_Properties {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		/*Class<?> forName = Class.forName("javaSe.Poker");
		Constructor<?> constructor = forName.getConstructor(String.class);
		Object newInstance = constructor.newInstance("eagle");*/

		Properties prop=new Properties();
		FileReader fr=new FileReader("class.txt");
		prop.load(fr);
		fr.close();
		//get�ļ������� className��property
		String className = prop.getProperty("className");
		String methodName =prop.getProperty("methodName");
		//����   propetryֵΪ  �ֽ����ļ����ַ�����ʾ
		Class<?> c = Class.forName(className);  //���Ե����ַ������
		//���ù���
		Constructor<?> con=c.getConstructor();
		Object newInstance = con.newInstance();
		//���÷���
				//��Ҫ���ݸ������Ĳ���
				TreeSet<String> ts= new TreeSet<>();
				ts.add("The world is alone");
		Method m=c.getDeclaredMethod(methodName,String.class,TreeSet.class); 
		//������Ϊ�ļ���methodName���ַ���ֵ.
		//�����βε����͵��ֽ����ļ�
		m.setAccessible(true);//����Ķ�����ʹ��ʱӦ��ȡ��Java���Է��ʼ�顣
		m.invoke(newInstance,"hello",ts);	 //ָ������󴫵�ʵ�ʲ���	
	}

}

