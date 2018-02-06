package javaSe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeSet;

import javax.activation.FileDataSource;
/*
 * ����:����ͨ��class�ļ�����,ʹ�ø��ļ��еĳ�Ա����,���췽��,��Ա����;
 * ��ȡclass�ļ�����ķ�ʽ��
 * A:Object���getClass()����
 * B:�������͵ľ�̬����class
 * C:Class���еľ�̬����
 * 	 public static Class forName(String className)
 */
class User {
	String name;
	int num;
	public User(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", num=" + num + "]";
	}
	private User(String name) {
		super();
		this.name = name;
	}
	
}
public class Reflect_Get_Class_Constructor_Method_Field {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		User u = new User();
		Class<? extends User> class1 = u.getClass();// 1 //Object��Ǿ�̬����
		System.out.println(class1);// ��ȡclass����
		//Object�� User����������
		Class<User> class2 = User.class;// 2  �������͵ľ�̬����.class
		System.out.println(class2);// ��ȡclass����
		//.class  User��
		Class<?> class3 = Class.forName("javaSe.User");// ��ȡclass���� //"javaSe.User"���ȫ·����
		System.out.println(class3);//3 Class���еľ�̬����
		//Class�� User ��������
		
        //Constructor �ղ� ����?
  		Constructor<?> con3 = class3.getConstructor();
  		Object newInstance3 = con3.newInstance();
  		System.out.println(newInstance3);
  	    //Constructor ���� ����?
  		Constructor<? extends User> con1=class1.getConstructor(String.class,int.class);
  		User newInstance1 = con1.newInstance("adam",28);
  		System.out.println(newInstance1);
  	    //con.setAccessible(true);ֵΪtrue��ָʾ����Ķ�����ʹ��ʱӦ��ȡ��Java���Է��ʼ�顣
		/*public Constructor[] getConstructors():���й������췽��
		public Constructor[] getDeclaredConstructors():���й��췽��*/
  		Constructor<User> con2=class2.getDeclaredConstructor(String.class);
  		con2.setAccessible(true); //˽��ǿ�Ʒ���
  		User newInstance2 = con2.newInstance("vivi");
  		System.out.println(newInstance2);
  		
  		/*Field [] fields= class3.getFields();
  		 Field [] fields= class3.getDeclaredFields(); */
  		//Field  ��ȡname��Ա
  		Class<?> c=Class.forName("javaSe.Poker");
  		Object newInstance = c.getConstructor().newInstance();
  		//c.getFields();c.getdeclaredFields();
  		Field nameField= c.getField("name");
  		nameField.set(newInstance, "bird");
  		System.out.println(newInstance);
  		//num��Ա
  		Field numField= c.getField("num"); 
  		numField.set(newInstance,33);
  		System.out.println(newInstance);
  		//˽�г�Ա
  		Field qualityField=c.getDeclaredField("quality"); //private field
  		qualityField.setAccessible(true);
  		qualityField.set(newInstance, "joker");
  		System.out.println(newInstance);
  		
  	   //method
  		Method[] methods = c.getMethods();  //��ȡ������������
  		Method[] declaredMethods = c.getDeclaredMethods(); //��ȡ�Լ������з��� ����˽��
  		for (Method method : declaredMethods) {
			System.out.println(method);
		}
  		//��һ����
  		Method method = c.getMethod("toString");
  		System.out.println(method.invoke(newInstance));
  		//˽�з�������
  		TreeSet<String> ts = new TreeSet<String>();ts.add("This world Blong to you");
  		method=c.getDeclaredMethod("ergodic", String.class,TreeSet.class);
  		method.setAccessible(true);
  		method.invoke(newInstance,"hallo",ts);
  		
	}
}

