package complex;

public class HashCode_Effect {

	public static void main(String[] args) {
/*
 Object类的hashCode根据内存地址生成
 String类的hashCode根据字符串内容生成
 Integer类的hashCode是整数数值
 hashCode可以看作对象的识别码身份证;
  哈希值并不是真实的内存地址
 */		
		Object o2=new Object();
		Object o1=new Object();
		System.out.println(o2.hashCode());//1704856573
		System.out.println(o1.hashCode());//705927765
		
		String s1="abc";
		String s2=new String("abc");
		System.out.println(s1.hashCode());//96354
		System.out.println(s2.hashCode());//96354
		System.out.println(s1==s2);//false
		
		Integer i1=110;
		Integer i2=110;
		System.out.println(i1.hashCode()); //110
		System.out.println(i2.hashCode()); //110
		
/*
"==" 确保数值相等 对于引用类型确保地址相同,无法确定对象是否相同
"equals"默认判断不同地址的对象是否相同,通过hashCode,提高哈希表性能;
使用时先用==判断地址,再用equals判断对象是否相同;
 */		
		s1=new String("abc");
		s2=new String("abc");
		System.out.println(s1==s2); //false
		System.out.println(s1.equals(s2)); //true
/*
 * ==如果两边是基本数据类型 ，比较的是具体的数值，如果两边是引用类型比较的是真实的内存地址
 * equals默认比较对象的哈希值
 */
		s1="abc";
		s2=new String("abc");
		changeFail(s1,s2);
		System.out.println(s1+" "+s2);  //形参操作不影响实参
		
		//空对象equals
		s1=new String();
		s2=new String();
		System.out.println(s1.equals(s2)); //true
		//使用时先用==判断地址,再用equals判断对象是否相同
		Object a1=new Object();
		Object a2=new Object();
		System.out.println(a1.equals(a2)); //false
	}
	public static void changeFail(String s1,String s2) {
		s1=s1+s2;
		s2=s1+s2;
	}

}
