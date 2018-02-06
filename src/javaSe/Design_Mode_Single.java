package javaSe;
/*
设计模式：经验的总结
	A:创建型	创建对象
	B:结构型	对象的组成
	C:行为型	对象的功能
创建型模式：
	1:简单工厂模式
	2:工厂方法模式
	3:设计模式
 */
public class Design_Mode_Single {

	public static void main(String[] args) {
		// 1 
		System.out.println(Single.getInstance());
		// 2 
		System.out.println(Alone.getInstance());
		// 3 java runtime类的使用体现
		//单例实例  每个java程序都有一个runtime实例,使用应用程序能与外部连接
		/*Runtime r= Runtime.getRuntime();
		r.exec("shutdown -s -t 10000");
		r.exec("shutdown -a");*/
	}
}

class SynSingle{
	private static SynSingle s = null;
	private SynSingle(){}
	public static SynSingle getInstance(){ //锁是谁？字节码文件对象；
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
	}//餓漢
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
	}//懶漢
}
/*class Runtime{
	private Runtime() {}
	private static Runtime currentRuntime = new Runtime();
	public static Runtime getRuntime() {
		return currentRuntime;
	}
}*/
