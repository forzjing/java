package javaSe;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

public class IO_LineNumberReader_RandomAccessFile {
	/*
	 * BufferedReader
	 * 		|--LineNumberReader
	 * 			public int getLineNumber()获得当前行号。 
	 * 			public void setLineNumber(int lineNumber)
	 */
	public static void main(String[] args) throws IOException {
		LineNumberReader lnr=new LineNumberReader(new FileReader("a.txt"));
		String line=null;
		while(  (line=lnr.readLine())  != null ) {
			System.out.println(lnr.getLineNumber()+":" +line);
		}
		lnr.close();
		
		//随机访问流对象
		randomAccessWrite();
		randomAccessRead();
		
	}
	 /* 		支持对文件的随机访问读取和写入。
	 * 
	 * public RandomAccessFile(String name,String mode)：第一个参数是文件路径，第二个参数是操作文件的模式。
	 * 		模式有四种，我们最常用的一种叫"rw",这种方式表示 可以写数据，也可以读取数据 
	 */
	private static void randomAccessRead() throws IOException{
		RandomAccessFile raf=new RandomAccessFile("raf.txt","rw");
		int i=raf.readInt();
		System.out.println(i);
		// 该文件指针可以通过 getFilePointer方法读取，并通过 seek 方法设置。
		System.out.println("当前文件的指针位置是：" + raf.getFilePointer());
		
		char ch=raf.readChar();
		System.out.println(ch);
		System.out.println("当前文件的指针位置是：" + raf.getFilePointer());
		
		String s = raf.readUTF();
		System.out.println(s);
		System.out.println("当前文件的指针位置是：" + raf.getFilePointer());
		
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
