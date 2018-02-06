package javaSe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeSet;

import javax.activation.FileDataSource;
/*
 * 反射:就是通过class文件对象,使用该文件中的成员变量,构造方法,成员方法;
 * 获取class文件对象的方式：
 * A:Object类的getClass()方法
 * B:数据类型的静态属性class
 * C:Class类中的静态方法
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
		Class<? extends User> class1 = u.getClass();// 1 //Object类非静态方法
		System.out.println(class1);// 获取class对象
		//Object类 User及所有子类
		Class<User> class2 = User.class;// 2  数据类型的静态属性.class
		System.out.println(class2);// 获取class对象
		//.class  User类
		Class<?> class3 = Class.forName("javaSe.User");// 获取class对象 //"javaSe.User"类的全路径名
		System.out.println(class3);//3 Class类中的静态方法
		//Class类 User 及所有类
		
        //Constructor 空参 泛型?
  		Constructor<?> con3 = class3.getConstructor();
  		Object newInstance3 = con3.newInstance();
  		System.out.println(newInstance3);
  	    //Constructor 带参 泛型?
  		Constructor<? extends User> con1=class1.getConstructor(String.class,int.class);
  		User newInstance1 = con1.newInstance("adam",28);
  		System.out.println(newInstance1);
  	    //con.setAccessible(true);值为true则指示反射的对象在使用时应该取消Java语言访问检查。
		/*public Constructor[] getConstructors():所有公共构造方法
		public Constructor[] getDeclaredConstructors():所有构造方法*/
  		Constructor<User> con2=class2.getDeclaredConstructor(String.class);
  		con2.setAccessible(true); //私有强制访问
  		User newInstance2 = con2.newInstance("vivi");
  		System.out.println(newInstance2);
  		
  		/*Field [] fields= class3.getFields();
  		 Field [] fields= class3.getDeclaredFields(); */
  		//Field  获取name成员
  		Class<?> c=Class.forName("javaSe.Poker");
  		Object newInstance = c.getConstructor().newInstance();
  		//c.getFields();c.getdeclaredFields();
  		Field nameField= c.getField("name");
  		nameField.set(newInstance, "bird");
  		System.out.println(newInstance);
  		//num成员
  		Field numField= c.getField("num"); 
  		numField.set(newInstance,33);
  		System.out.println(newInstance);
  		//私有成员
  		Field qualityField=c.getDeclaredField("quality"); //private field
  		qualityField.setAccessible(true);
  		qualityField.set(newInstance, "joker");
  		System.out.println(newInstance);
  		
  	   //method
  		Method[] methods = c.getMethods();  //获取方法包括父亲
  		Method[] declaredMethods = c.getDeclaredMethods(); //获取自己的所有方法 包括私有
  		for (Method method : declaredMethods) {
			System.out.println(method);
		}
  		//单一调用
  		Method method = c.getMethod("toString");
  		System.out.println(method.invoke(newInstance));
  		//私有方法调用
  		TreeSet<String> ts = new TreeSet<String>();ts.add("This world Blong to you");
  		method=c.getDeclaredMethod("ergodic", String.class,TreeSet.class);
  		method.setAccessible(true);
  		method.invoke(newInstance,"hallo",ts);
  		
	}
}

