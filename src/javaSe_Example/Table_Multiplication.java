package javaSe_Example;

import java.util.Scanner;

public class Table_Multiplication {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("input 1--9 please");
		
		tableFun(sc.nextInt());
		sc.close();
		
		
		triangle(10);
		jinZhiTa(10);
		table();
	}
	
	private static void triangle(int a){
		for( int j=1; j<=a;j++){
			int times=j;
			while(times != 0){
				System.out.print("*");
				times--;
			}
		}
	}
	private static void jinZhiTa(int a){
		for( int j=1;j<=a;j++){
			int times=(2*j) -1;  //控制星号数量
			int time=0;		//控制空格数量
			while(time!=(a-j)){
				System.out.print(" ");
				times++;
			}
			while(times != 0){
				System.out.print("*");
				times--;
			}
			System.out.print("\n");
		}
	}
	
	private static void table(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				if( (i==3 && j==3)  || (i==4 && j==3) ){
					System.out.print(  "  "+j+"*"+i+"="+  i*j  +" ");
				}else{
					System.out.print( j+ "*"+ i+ "=" +  i*j+ " ");
				}
			}
			System.out.print("\r\n");
		}
	}
	
	private static void tableFun(int a) {
		if(a>=1&&a<=9) {
			for(int x=1;x<=a;x++) {
				for(int y=1;y<=x;y++) {
					System.out.print(y+"*"+x+"="+(x*y)+"\t");
				}System.out.println(" ");
			}
			System.out.println("\r\n");
			for(int x=a;x>0;x--) {   //数小加加 数大减减  大的大于等于小的 初始>0
				for(int y=1;y<=x;y++) {
					System.out.print(y+"*"+x+"="+x*y+"\t");
				}System.out.println(" ");
			}
		}else {
			System.out.println(" need int 1-9 ");
		}
	}
}
