package javaSe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Design_Mode_Template_Pattern {

	public static void main(String[] args) {
		GetTime  gt=new InstanceCode();
		System.out.println(gt.getTime()+"ms");
		gt= new ForCode();
		System.out.println(gt.getTime()+"ms");
	}

}
/*
 * 模板设计模式，1抽象类中提供部分功能，
 * 				2用其他方法调用这个没实现的功能，
 * 				3子类去实现这个抽象方法。
 */
abstract class GetTime{
	public long getTime() {
		long start=System.currentTimeMillis();
		code();
		long end=System.currentTimeMillis();
		return end-start;
	}
	public abstract void code();
}
class InstanceCode extends GetTime{   //override code方法就能计算运行时间
	@Override
	public void code() {
		try {
			BufferedInputStream bis=new BufferedInputStream(
					new FileInputStream("a.txt"));
			BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream("b.txt"));
			byte[] b=new byte[1024];
			int len=0;
			while(  (len=bis.read(b))  != -1) {
				bos.write(b,0,len);
			}
			bos.close();
			bis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
class ForCode extends GetTime{
	@Override
	public void code() {
		for(int x=0;x<10;x++) {
			System.out.println(x);
		}
	}
}