package javaSe;
/*
���ģʽ��������ܽ�
	A:������	��������
	B:�ṹ��	��������
	C:��Ϊ��	����Ĺ���
������ģʽ��
	1:�򵥹���ģʽ
	2:��������ģʽ
	3:���ģʽ
 */
public class Design_Mode_Single {

	public static void main(String[] args) {
		// 1 
		System.out.println(Single.getInstance());
		// 2 
		System.out.println(Alone.getInstance());
		// 3 java runtime���ʹ������
		//����ʵ��  ÿ��java������һ��runtimeʵ��,ʹ��Ӧ�ó��������ⲿ����
		/*Runtime r= Runtime.getRuntime();
		r.exec("shutdown -s -t 10000");
		r.exec("shutdown -a");*/
	}
}

class SynSingle{
	private static SynSingle s = null;
	private SynSingle(){}
	public static SynSingle getInstance(){ //����˭���ֽ����ļ�����
		if(s == null){
			synchronized(SynSingle.class){
				if(s == null)
					s = new SynSingle();
			}
		}
		return s;
	}
} 

class Single {
	private Single() {
	}
	private static Single single = new Single();

	public static Single getInstance() {
		return single;
	}//�I�h
}

class Alone {
	private Alone() {
	}
	private static Alone alone = null;

	public static Alone getInstance() {
		if (alone != null) {
			return alone;
		}
		return new Alone();
	}//�Нh
}
/*class Runtime{
	private Runtime() {}
	private static Runtime currentRuntime = new Runtime();
	public static Runtime getRuntime() {
		return currentRuntime;
	}
}*/
