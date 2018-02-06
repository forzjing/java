package interview;

public class Plug {

	public static void main(String[] args) {
		/*String s;
		System.out.println("s="+s);*/
	/*	int x=4;
		System.out.println("value is"+( (x>4)?99.9:9 ) );*///9.0
		
		int i=2;  //2 
		System.out.println(i);
		i=i++;    //2   i=2;
		System.out.println(i);
		int j=i++; //   j=2;  i=3;
		System.out.println(i+"--"+j);
		
		int a=0;
		//a=++a;  a=++a; a=++a; a=++a; a=++a;   //+1 每次自加1
		//a=a++;   // 0
		//a=a++;a=a++;a=a++;  //一直是0
		System.out.println(a);
		
		System.out.println("-------");
		a=10;
		int b=(--a)+(a--)+(a*10);
		System.out.println(a+"---"+b);
	}
}
