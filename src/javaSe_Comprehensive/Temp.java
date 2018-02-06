package javaSe_Comprehensive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Temp {

	public static void main(String[] args) throws IOException {
		ArrayList<String> list= new ArrayList<>();	
		BufferedReader br=new BufferedReader(new FileReader("goods.txt"));
		int sheBei=0;
		int qiCai=0;
		String line=null;
		while(  (line =br.readLine()) != null) {
			list.add(line);
			if(line.contains("election")) {
				sheBei++;
			}else if(line.contains("music")) {
				qiCai++;
			}
		}
		System.out.println("election");
		System.out.println("music");
		br.close();
		
		String regex="-";
		for (String string : list) {
			
		}
		
		for (String path : list) {
			System.out.println(path);
		}
	}

}

