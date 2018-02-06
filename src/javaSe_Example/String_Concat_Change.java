package javaSe_Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class String_Concat_Change {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\Neon\\workspace\\exercises\\javaSe_Example\\aaa.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\Neon\\workspace\\exercises\\javaSe_Example\\bbb.txt"));
	
		String s=null;
		while(  (s=br.readLine()) != null ) {
			int start= s.indexOf("_");
			String s1=s.substring(0,start);
			
			int end= s.lastIndexOf("_");
			String s2=s.substring(end);
			String target=s1.concat(s2);
			
			bw.write(target);
			bw.newLine();
			//bw.flush(); 同样写入成功
			System.out.println(target);
		}
		bw.close();
		br.close();
	}

}
