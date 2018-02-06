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
		ArrayList<Integer> list = new ArrayList<>();// Integer���ͼ�����jvm��ʵ�ʴ洢����Object����
		// �����Ǳ���ʱ������,�������,����ʱ���ټ��
		// ʹ�÷���������������ڼ����д洢Object����
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
		Class c=obj.getClass();  //�Զ��巽���������ô�������field
		Field field=c.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj,value);
		System.out.println(obj);
	}	

}
