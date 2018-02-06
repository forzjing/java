package javaSe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Design_Mode_Decorate {

	public static void main(String[] args) {
		Phone p=new Iphone();
		PhoneDecorate pd=new RingPhoneDecorate(new MusicPhoneDecorate(p));
		pd.call();
		//System.out.println("...................ok");
		
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc=new Scanner(System.in);*/
	}
}

abstract interface Phone{
	 public abstract void call();
}
abstract class PhoneDecorate implements Phone{
	private Phone p;
	public PhoneDecorate (Phone p) {
		this.p=p;
	}
	@Override
	public void call() {
		this.p.call();
	}
}
class MusicPhoneDecorate extends PhoneDecorate{
	public MusicPhoneDecorate(Phone p) {
		super(p);
	}
	@Override
	public void call() {	
		super.call();
		System.out.println("this Phone is Playing music..");
	}
}
class RingPhoneDecorate extends PhoneDecorate{

	public RingPhoneDecorate(Phone p) {
		super(p);
		// TODO 自动生成的构造函数存根
	}
	@Override
	public void call() {
		System.out.println("this Phone is ringing..");
		super.call();
	}
}
class Iphone implements Phone{
	@Override
	public void call() {
		System.out.println("Iphone is calling...");
	}
}



