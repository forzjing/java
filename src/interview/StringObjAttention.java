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
	{	//没有更改，没有返回
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
