package javaSe_Comprehensive;
/*
1.����һ��ѧ�������԰�������name;���ĳɼ���chinese;��ѧ�ɼ���math��Ӣ��ɼ���english
 ��������������ѧӢ��ɼ��ֵܷķ���
2.����ѭ������¼���ĸ�ѧ���������͸��Ƴɼ�����װ��ѧ�����������ӵ�TreeSet�����
3.�����ܷ��е͵��ߵķ�ʽ�����
4.�ڱ�Java Project �´���file�ļ�test.txt
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Writer_Student_Object {

	public static void main(String[] args) throws IOException { //exception
		Scanner sc= new Scanner(System.in);
		TreeSet<Student> tSet= new TreeSet<Student>();
		for(int x=0;x<2;x++) {
			Student student= new Student();
			System.out.println("name");
			student.setName(sc.next());
			System.out.println("chinese");
			student.setChinese(Integer.valueOf(sc.next()));
			System.out.println("math");
			student.setMath(Integer.valueOf(sc.next()));
			System.out.println("english");
			student.setEnglish(Integer.valueOf(sc.next()));
			
			tSet.add(student);
		}
		for (Student student : tSet) {
			System.out.println(student);
		}
		
		//save file
		File file= new File("Student.txt");
		BufferedWriter bw= new BufferedWriter(new FileWriter(file));
		
		bw.write("total\t"+"name\t"+"chinese\t"+"math\t"+"english"+"\r\n" );
		for (Student student : tSet) {
			bw.write(student.toString());
			bw.newLine();
			bw.flush();
		}
		bw.close();
		sc.close();
	}
}

class Student implements Comparable<Student>{
	String name;
	int chinese;
	int math;
	int english;
	@Override
	public int compareTo(Student o) {
		int num= o.sum(chinese,math,english) - this.sum(chinese,math,english);
		int num1=  num ==0 ?  o.name.compareTo(name) :num;
		int num2=  num1==0?  o.chinese- chinese : num1;
		int num3=  num2==0? o.math - math : num2;
		int num4 =  num3 ==0? o.english -english : num3;
		return num4;
	}
	public int sum(int chinese, int math, int english) {
		return chinese+math+english;
	}
	@Override
	public String toString() {
		return  this.sum(chinese, math, english)+"    name=" + name + "   chinese=" + chinese + "   math=" + math + "  english=" + english ;
	}
	public Student() {
		super();
	}
	public Student(String name, int chinese, int math, int english) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}	
	
}
