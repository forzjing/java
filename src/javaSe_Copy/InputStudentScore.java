package javaSe_Copy;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class InputStudentScore {

	 
	public static void main(String[] args){

		 TreeSet<Student> ts=new TreeSet<Student>(new Student());
			Scanner sc= new Scanner(System.in);
			for(int i=0;i<2;i++){
				System.out.println("input.."+(i+1)+"name");
				String name=sc.nextLine();
				System.out.println("intpurt...english");
				String english=sc.nextLine();
				System.out.println("intput math");
				String math=sc.nextLine();
				System.out.println("intput..chinese");
				String chinese=sc.nextLine();
				
				Student stu=new Student();
				stu.setName(name);
				stu.setEnglish(Integer.valueOf(english));
				stu.setMath(Integer.valueOf(math));
				stu.setChinese(Integer.valueOf(chinese));
				
				ts.add(stu);
				
			} 
			System.out.println("name"+"\t"+"sum"+"\t"+"english"+"\t"+"math"+"\t"+"chinese");
			for(Student s:ts){
				System.out.println(s);
				}
			sc.close();
	 }

}


class Student implements Comparator<Student>{
	private String name;
	private int chinese;
	private int english;
	private int math;
	
	public void setName(String name){this.name=name;}
	public void setChinese(int chinese){this.chinese=chinese;}
	public void setMath(int math){this.math=math;}
	public void setEnglish(int english){this.english=english;}
	
	public String getName(){return name;}
	public int getChinese(){return chinese;}
	public int getEnglish(){return english;}
	public int getMath(){return math;}
	
	public int sum(){return chinese+math+english;}
	public int compare(Student s1,Student s2){
		int num=s1.sum()-s2.sum();
		int num1=  num==0? s1.chinese-s2.chinese : num;
		int num2=  num1==0?  s1.math-s2.math: num1;
		int num3=  num2==0?  s1.english -s2.english :num2;
		int num4= num3==0? s1.name.compareTo(s2.name): num3;
		return num4;
	}
	
	public String toString(){
	
		return getName()+"\t"+this.sum()+"\t"+getChinese()+"\t"+getEnglish() +"\t"+getMath();
	
	}
 
 
 }
