package javaSe;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties_Load_Store {

	public static void main(String[] args) throws IOException {
		/*
		 * getProperty();
		 * store(new FileWriter("a.txt"),"#ËµÃ÷ÎÄ×Ö");
		 * load(new FileReader("a.txt"));
		 * setProperty();
		 */
		File file=new File("aa.txt");
		FileWriter fw=new FileWriter(file);
		fw.write("username=admin"+"\r"+"password=123456");
		fw.flush();
		fw.close();	
		
		Properties p=new Properties();
		FileReader fr=new FileReader(file);
		p.load(fr);
		
		String value1 = p.getProperty("username");
		p.setProperty("password", "23456");
		Object value2 = p.get("password");
		System.out.println(value1);
		System.out.println(value2);
		
		fw=new FileWriter("abc.txt");
		p.store(fw,"explain");
		
		fr.close();
		fw.close();	
	}

}
