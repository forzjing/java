package javaSe;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 *  JDK5: 自动装拆箱,泛型,foreach,静态导入,可变参数,枚举
 *  foreach 需要泛型并且目标不能为null
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
		// try-with-resources 语句
		// try(必须是java.lang.AutoCloseable的子类对象){…}

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

		// 改进版的代码
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
