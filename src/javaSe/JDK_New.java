package javaSe;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 *  JDK5: �Զ�װ����,����,foreach,��̬����,�ɱ����,ö��
 *  foreach ��Ҫ���Ͳ���Ŀ�겻��Ϊnull
 *  if(list !=null){
 *  	for(String s:list){
 *  		System.out.println(s);
 *  	} 
 *  }
 */
public class JDK_New {

	public static void main(String[] args) {
		method();
	}

	private static void method() {
		// try-with-resources ���
		// try(������java.lang.AutoCloseable���������){��}

		try {
			FileReader fr = new FileReader("a.txt");
			FileWriter fw = new FileWriter("b.txt");
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
			fw.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// �Ľ���Ĵ���
		try (FileReader fr = new FileReader("a.txt");
				FileWriter fw = new FileWriter("b.txt");) {
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
