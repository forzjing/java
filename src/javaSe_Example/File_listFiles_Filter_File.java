package javaSe_Example;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

class MyFilter implements FileFilter{  //·������
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(".txt");
	}
}
class MyFilenameFilter implements FilenameFilter{ //�ļ�������
	@Override
	public boolean accept(File dir, String name) {
		return new File(dir,name).isFile()&&name.endsWith(".txt");
	}
}
public class File_listFiles_Filter_File {

	public static void main(String[] args) {
		File file= new File("D:\\Neon\\workspace");
		 //     ".\\src\\dom4jparse\\4.txt"  "D:\\Neon\\Neon1EE\\parsexml\\src\\dom4jparse\\4.txt"
		 //     "../parsexml/src/dom4jparse/94.txt"
		 //     "src/dom4jparse/1.txt"   "./src/dom4jparse/2.txt"
		 // listFilesʹ��FileFlter������
		File[] files=file.listFiles( new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt");
			}
		});
		for (File f : files) {
			System.out.println(f);
		}
		
		//ʹ�� FilenameFilter������
		String [] strArray= file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile()&&name.endsWith(".txt");
			}
		});
		System.out.println(Arrays.toString(files));
		
		//û�й�������ʵ�� .txt
		filter(file);	
	}
	//û�й�������ʵ�� .txt
	private static void filter(File file) {
		File [] files= file.listFiles();
		for( File f: files) {
			if(f.isDirectory()) {filter(f);}
			else {
				if(f.getName().endsWith(".java")) {
					System.out.println(f.getAbsolutePath());
				}
			}
		}
	}
}
