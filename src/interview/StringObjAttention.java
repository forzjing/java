package interview;

public class StringObjAttention {

	public static void main(String[] args) {

		String str="1234";
		changeStr(str);
		System.out.println(str);
		
		ObjectClass object=new ObjectClass(str);
		changeObj(object);
		System.out.println(object.value);
	}
	
	public static void changeStr(String str)
	{
		str="welcome";
	}
	public static void changeObj(ObjectClass object)
	{	//û�и��ģ�û�з���
		object=new ObjectClass("welcome");
	}

}
class ObjectClass{
	String value=null;
	public ObjectClass (final String value)
	{
		this.value=value;
	}
}
