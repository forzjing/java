package complex;

public class HashCode_Effect {

	public static void main(String[] args) {
/*
 Object���hashCode�����ڴ��ַ����
 String���hashCode�����ַ�����������
 Integer���hashCode��������ֵ
 hashCode���Կ��������ʶ�������֤;
  ��ϣֵ��������ʵ���ڴ��ַ
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
"==" ȷ����ֵ��� ������������ȷ����ַ��ͬ,�޷�ȷ�������Ƿ���ͬ
"equals"Ĭ���жϲ�ͬ��ַ�Ķ����Ƿ���ͬ,ͨ��hashCode,��߹�ϣ������;
ʹ��ʱ����==�жϵ�ַ,����equals�ж϶����Ƿ���ͬ;
 */		
		s1=new String("abc");
		s2=new String("abc");
		System.out.println(s1==s2); //false
		System.out.println(s1.equals(s2)); //true
/*
 * ==��������ǻ����������� ���Ƚϵ��Ǿ������ֵ������������������ͱȽϵ�����ʵ���ڴ��ַ
 * equalsĬ�ϱȽ϶���Ĺ�ϣֵ
 */
		s1="abc";
		s2=new String("abc");
		changeFail(s1,s2);
		System.out.println(s1+" "+s2);  //�ββ�����Ӱ��ʵ��
		
		//�ն���equals
		s1=new String();
		s2=new String();
		System.out.println(s1.equals(s2)); //true
		//ʹ��ʱ����==�жϵ�ַ,����equals�ж϶����Ƿ���ͬ
		Object a1=new Object();
		Object a2=new Object();
		System.out.println(a1.equals(a2)); //false
	}
	public static void changeFail(String s1,String s2) {
		s1=s1+s2;
		s2=s1+s2;
	}

}
