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
		//������
		dataWrite();
		dataRead();
		//�ڴ������
		byteArrayStream();
		//��ӡ�� PrintStream PrintWriter
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
	 * ���Զ�д�����������͵�����
	 * ������������DataInputStream
	 * 			DataInputStream(InputStream in)
	 * �����������DataOutputStream
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
	 * �ڴ�����������ڴ�����ʱ�洢��Ϣ�ģ�������������ݾʹ��ڴ�����ʧ��
	 * �ֽ����飺
	 * 		ByteArrayInputStream
	 * 		ByteArrayOutputStream
	 * �ַ����飺
	 * 		CharArrayReader
	 * 		CharArrayWriter
	 * �ַ�����
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
	 * ��ӡ��
	 * �ֽ�����ӡ��	PrintStream
	 * �ַ���ӡ��	PrintWriter
	 * 
	 * ��ӡ�����ص㣺
	 * 		A:ֻ��д���ݵģ�û�ж�ȡ���ݡ�ֻ�ܲ���Ŀ�ĵأ����ܲ�������Դ��
	 * 		B:���Բ����������͵����ݡ�
	 * 		C:����������Զ�ˢ�£��ܹ��Զ�ˢ�¡�
	 * 		D:�����ǿ���ֱ�Ӳ����ı��ļ��ġ�
	 * 			��Щ�������ǿ���ֱ�Ӳ����ı��ļ�����?
	 * 			FileInputStream
	 * 			FileOutputStream
	 * 			FileReader
	 * 			FileWriter
	 * 			PrintStream
	 * 			PrintWriter
	 * 			��API,��������Ĺ��췽�������ͬʱ��File���ͺ�String���͵Ĳ�����һ����˵���ǿ���ֱ�Ӳ����ļ��ġ�
	 * 
	 * 			����
	 * 				�������������ܹ�ֱ�Ӷ�д�ļ���
	 * 				�߼������ڻ������������ṩ��һЩ�����Ĺ���
	 */
	private static void printWriter() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("a.txt"));
		PrintWriter pw=new PrintWriter(new FileWriter("b.txt"),true);//�����Զ�ˢ��
		String line=null;
		while(  (line=br.readLine() )  != null) {
			pw.println(line);
		}
		pw.close();
		br.close();
	}
	/*
	 * ��׼���������
	 * System���е�������Ա������
	 *		public static final InputStream in ����׼����������
	 * 		public static final PrintStream out ����׼���������
	 * 
	 * 		InputStream is = System.in;
	 * 		PrintStream ps = System.out;
	 */
	private static void sysInOut() throws IOException{
		System.out.println("hallo world");
		PrintStream ps=System.out;
		ps.println("helloworld");
		ps.println();
		//ps.print();�����ڵķ���;
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
