package javaSe;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

public class IO_LineNumberReader_RandomAccessFile {
	/*
	 * BufferedReader
	 * 		|--LineNumberReader
	 * 			public int getLineNumber()��õ�ǰ�кš� 
	 * 			public void setLineNumber(int lineNumber)
	 */
	public static void main(String[] args) throws IOException {
		LineNumberReader lnr=new LineNumberReader(new FileReader("a.txt"));
		String line=null;
		while(  (line=lnr.readLine())  != null ) {
			System.out.println(lnr.getLineNumber()+":" +line);
		}
		lnr.close();
		
		//�������������
		randomAccessWrite();
		randomAccessRead();
		
	}
	 /* 		֧�ֶ��ļ���������ʶ�ȡ��д�롣
	 * 
	 * public RandomAccessFile(String name,String mode)����һ���������ļ�·�����ڶ��������ǲ����ļ���ģʽ��
	 * 		ģʽ�����֣�������õ�һ�ֽ�"rw",���ַ�ʽ��ʾ ����д���ݣ�Ҳ���Զ�ȡ���� 
	 */
	private static void randomAccessRead() throws IOException{
		RandomAccessFile raf=new RandomAccessFile("raf.txt","rw");
		int i=raf.readInt();
		System.out.println(i);
		// ���ļ�ָ�����ͨ�� getFilePointer������ȡ����ͨ�� seek �������á�
		System.out.println("��ǰ�ļ���ָ��λ���ǣ�" + raf.getFilePointer());
		
		char ch=raf.readChar();
		System.out.println(ch);
		System.out.println("��ǰ�ļ���ָ��λ���ǣ�" + raf.getFilePointer());
		
		String s = raf.readUTF();
		System.out.println(s);
		System.out.println("��ǰ�ļ���ָ��λ���ǣ�" + raf.getFilePointer());
		
		raf.seek(4);
		ch = raf.readChar();
		System.out.println(ch);
	}
	private static void randomAccessWrite()throws IOException{
		RandomAccessFile raf=new RandomAccessFile("raf.txt","rw");
		
		raf.writeInt(100);
		raf.writeChar('a');
		raf.writeUTF("china");
		raf.close();
	}

}
