package javaSe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_File_Copy_Byte_4 {

	public static void main(String[] args) throws IOException {
		// 1�ֽ���
		FileInputStream fis = new FileInputStream("a.txt");
		FileOutputStream fos = new FileOutputStream("bx.txt",true);
		// ����һ�������ָ�� name ���ļ���д�����ݵ�����ļ�����
		//����ڶ�������Ϊ true�����ֽ�д���ļ�ĩβ����������д���ļ���ʼ����
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
		// ��ΰ��ù����������³�ʼ��Ϊ��
		b = new byte[1024];
		len = 0;
		while ((len = bis.read(b)) != -1) {
			bos.write(b, 0, len);
		}
		bos.close();
		bis.close();
	}
}
