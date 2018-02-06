package javaSe_Example;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javaSe.Poker;

public class Refect_SkipCompelType_SetFieldMethod {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		ArrayList<Integer> list = new ArrayList<>();// Integer类型集合在jvm中实际存储的是Object类型
		// 泛型是编译时起作用,辅助编程,运行时不再检查
		// 使用反射可以跳过泛型在集合中存储Object类型
		Class<? extends ArrayList> c = list.getClass();
		Method method = c.getMethod("add", Object.class);

		method.invoke(list, "hello");
		method.invoke(list, "java");
		method.invoke(list, "world");
		System.out.println(list);
		Poker p=new Poker();
		setField(p,"name","King");
		setField(p,"num",43);
		setField(p,"quality","bird");
	}
	private static void setField(Object obj,String fieldName,Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class c=obj.getClass();  //自定义方法用来设置传入对象的field
		Field field=c.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj,value);
		System.out.println(obj);
	}	

}
