package javaSe;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class IO_Data_ByteArray_Print_SystemIn_Out {

	public static void main(String[] args) throws IOException {
		//数据流
		dataWrite();
		dataRead();
		//内存操作流
		byteArrayStream();
		//打印流 PrintStream PrintWriter
		printWriter();
		//System.in  System.out
		sysInOut();
		
		
	}
	private static void dataWrite() throws IOException{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("dos.txt"));
		
		dos.writeByte(10);
		dos.writeShort(100);
		dos.writeInt(1000);
		dos.writeLong(10000);
		dos.writeFloat(12.34F);
		dos.writeDouble(12.55);
		dos.writeChar('a');
		dos.writeBoolean(true);
		dos.close();
	}
	/*
	 * 可以读写基本数据类型的数据
	 * 数据输入流：DataInputStream
	 * 			DataInputStream(InputStream in)
	 * 数据输出流：DataOutputStream
	 * 			DataOutputStream(OutputStream out) 
	 */
	private static void dataRead() throws IOException{
		DataInputStream dis=new DataInputStream(new FileInputStream("dos.txt"));
		byte b=dis.readByte();
		short s=dis.readShort();
		int i=dis.readInt();
		long l=dis.readLong();
		float f=dis.readFloat();
		double d=dis.readDouble();
		char c=dis.readChar();
		boolean boo=dis.readBoolean();
		dis.close();
		System.out.println("+"+b+s+i+l+f+d+c+boo);
	}
	/*
	 * 内存操作流：用于处理临时存储信息的，程序结束，数据就从内存中消失。
	 * 字节数组：
	 * 		ByteArrayInputStream
	 * 		ByteArrayOutputStream
	 * 字符数组：
	 * 		CharArrayReader
	 * 		CharArrayWriter
	 * 字符串：
	 * 		StringReader
	 * 		StringWriter
	 */
	private static void byteArrayStream() throws IOException{
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		for(int x=0;x<10;x++) {
			baos.write(  ("hello"+x).getBytes() );
		}
		byte[] bys=baos.toByteArray();
		
		ByteArrayInputStream bais=new ByteArrayInputStream(bys);
		int by=0;
		while(   (by=bais.read()) != -1) {
			System.out.println( (char)by);
		}
	}
	
	/*
	 * 打印流
	 * 字节流打印流	PrintStream
	 * 字符打印流	PrintWriter
	 * 
	 * 打印流的特点：
	 * 		A:只有写数据的，没有读取数据。只能操作目的地，不能操作数据源。
	 * 		B:可以操作任意类型的数据。
	 * 		C:如果启动了自动刷新，能够自动刷新。
	 * 		D:该流是可以直接操作文本文件的。
	 * 			哪些流对象是可以直接操作文本文件的呢?
	 * 			FileInputStream
	 * 			FileOutputStream
	 * 			FileReader
	 * 			FileWriter
	 * 			PrintStream
	 * 			PrintWriter
	 * 			看API,查流对象的构造方法，如果同时有File类型和String类型的参数，一般来说就是可以直接操作文件的。
	 * 
	 * 			流：
	 * 				基本流：就是能够直接读写文件的
	 * 				高级流：在基本流基础上提供了一些其他的功能
	 */
	private static void printWriter() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("a.txt"));
		PrintWriter pw=new PrintWriter(new FileWriter("b.txt"),true);//启用自动刷新
		String line=null;
		while(  (line=br.readLine() )  != null) {
			pw.println(line);
		}
		pw.close();
		br.close();
	}
	/*
	 * 标准输入输出流
	 * System类中的两个成员变量：
	 *		public static final InputStream in “标准”输入流。
	 * 		public static final PrintStream out “标准”输出流。
	 * 
	 * 		InputStream is = System.in;
	 * 		PrintStream ps = System.out;
	 */
	private static void sysInOut() throws IOException{
		System.out.println("hallo world");
		PrintStream ps=System.out;
		ps.println("helloworld");
		ps.println();
		//ps.print();不存在的方法;
		//System.out.println();
		//System.out.print(0);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input string");
		String line=br.readLine();
		System.out.println("output " + line);
		System.out.println("input a int");
		line=br.readLine();
		int i=Integer.parseInt(line);
		System.out.println("output"+ i);
	}
}
