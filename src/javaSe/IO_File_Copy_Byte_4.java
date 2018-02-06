package javaSe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_File_Copy_Byte_4 {

	public static void main(String[] args) throws IOException {
		// 1字节流
		FileInputStream fis = new FileInputStream("a.txt");
		FileOutputStream fos = new FileOutputStream("bx.txt",true);
		// 创建一个向具有指定 name 的文件中写入数据的输出文件流。
		//如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
		fos.write("hallo".getBytes());
		fos.write("java\r".getBytes());
		int a = 0;
		while ((a = fis.read()) != -1) {
			fos.write(a);
		}
		// 2
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = fis.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		
		fos.close();
		fis.close();
		// ******//3
		// Buffered**************////****************//////*********************
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.txt"));
		len = 0;
		while ((len = bis.read()) != -1) {
			bos.write(len);
		}
		// 4
		// 如何把用过的数组重新初始化为空
		b = new byte[1024];
		len = 0;
		while ((len = bis.read(b)) != -1) {
			bos.write(b, 0, len);
		}
		bos.close();
		bis.close();
	}
}
