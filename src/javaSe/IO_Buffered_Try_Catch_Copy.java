package javaSe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO_Buffered_Try_Catch_Copy {

	public static void main(String[] args) {
		File f1=new File("a.txt");
		File f2= new File("b.txt");
		FileWriter fw=null;
		FileReader fr=null;
		BufferedWriter bw=null;
		BufferedReader br=null;
		
		try {
			fw=new FileWriter(f1);
			fw.write("abcdefghi");
			fw.flush();
			fw=new FileWriter(f2);
			
			bw=new BufferedWriter(fw);
			
			fr=new FileReader(f1);
			br=new BufferedReader(fr);
			
			String line=null;
			while( (line=br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		}catch(IOException e) {
			throw new RuntimeException ("copy fail");
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e){
				throw new RuntimeException("bufferedReader close fail");
			}finally {
				try {
					if(bw != null) {
						bw.close();
					}
				}catch(IOException e){
					throw new RuntimeException("bufferedWrite close fail");
				}
			}
		}
	}
}
