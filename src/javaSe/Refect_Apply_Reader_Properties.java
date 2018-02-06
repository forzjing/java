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
		//get文件里面内 className的property
		String className = prop.getProperty("className");
		String methodName =prop.getProperty("methodName");
		//反射   propetry值为  字节码文件的字符串表示
		Class<?> c = Class.forName(className);  //所以第三种方法最常用
		//调用构造
		Constructor<?> con=c.getConstructor();
		Object newInstance = con.newInstance();
		//调用方法
				//需要传递给方法的参数
				TreeSet<String> ts= new TreeSet<>();
				ts.add("The world is alone");
		Method m=c.getDeclaredMethod(methodName,String.class,TreeSet.class); 
		//方法名为文件内methodName的字符串值.
		//所有形参的类型的字节码文件
		m.setAccessible(true);//反射的对象在使用时应该取消Java语言访问检查。
		m.invoke(newInstance,"hello",ts);	 //指定对象后传递实际参数	
	}

}

