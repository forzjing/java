package javaSe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * InputMismatchException������ĺ�����Ҫ�Ĳ�ƥ��
 */
public class IO_File_Copy_Char_5 {

	public static void main(String[] args) throws IOException {
		// 1 ��ת�� //�ֽ���+�����=�ַ���
		InputStreamReader ipsr = new InputStreamReader(new FileInputStream("a.txt"), "utf-8");
		OutputStreamWriter opsw = new OutputStreamWriter(new FileOutputStream("b.txt"), "utf-8");
		int len = 0;
		while ((len = ipsr.read()) != -1) {
			opsw.write(len);
		}
		// 2
		char[] ch = new char[1024];
		len = 0;
		while ((len = ipsr.read(ch)) != -1) { // ���ض�ȡ���ַ����鳤��
			opsw.write(ch);
			opsw.flush();
		}
		ipsr.close();
		opsw.close();
		// 1�ַ���ԭ��
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt"), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt"), "UTF-8"));
		len = 0;
		while ((len = br.read()) != -1) {
			bw.write(len);
			bw.flush();
		}
		// �ַ���ԭ��2
		ch = new char[1024];
		len = 0;
		while ((len = br.read(ch)) != -1) {
			bw.write(ch, 0, len);
			bw.flush();
		}
//*************// 1�ַ�������ʹ��**************************************************************
		br = new BufferedReader(new FileReader("a.txt"));
		bw = new BufferedWriter(new FileWriter("b.txt"));
		len = 0;
		while ((len = br.read()) != -1) {
			bw.write(len);   //һ��һ���ַ�
			bw.flush();
		}
		// 2
		ch = new char[1024];
		len = 0;
		while ((len = br.read(ch)) != -1) {
			bw.write(ch, 0, len);
			bw.flush();  //һ��һ���ַ�����
		}
		bw.close();
		br.close();

		// 1�ַ���ʹ�� try catch
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("a.txt");
			fw = new FileWriter("b.txt");
			len = 0;
			while ((len = fr.read()) != -1) {
				fw.write(len);   //�����ַ���һ�ζ�дһ���ַ�
				fw.flush();
			}
			// 2
			ch = new char[1024];
			len = 0;
			while ((len = fr.read(ch)) != -1) {
				fw.write(ch, 0, len);   //�����ַ���һ�ζ�дһ���ַ�����
				fw.flush();
			}
		} catch (IOException e) {
			throw new RuntimeException("copy fail");
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("write fail");
			}
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("read fail");
			}
		}
		// ************// 3
		// Buffered**********/////**********************////*************************
		bw = null;
		br = null;
		FileWriter fw1 = null;
		FileReader fr1 = null;
		try {
			fw1 = new FileWriter("b.txt");
			bw = new BufferedWriter(fw1);
			fr1 = new FileReader("a.txt");
			br = new BufferedReader(fr1);
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);   //һ�ζ�дһ���ַ��� һ��
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			throw new RuntimeException("copy fail");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("bufferedReader close fail");
			} finally {
				try {
					if (bw != null) {
						bw.close();
					}
				} catch (IOException e) {
					throw new RuntimeException("bufferedReader close fail");
				}
			}
		}
		// 4
		br = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
		len = 0;
		while ((len = br.read()) != -1) {
			bw.write(len);   //һ�ζ�дһ���ַ�
			bw.flush();
		}
		// 5
		ch = new char[1024];
		len = 0;
		while ((len = br.read(ch)) != -1) {
			bw.write(ch, 0, len);   //һ�ζ�дһ���ַ�����
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
