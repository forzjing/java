package javaSe_Example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_listFiles_Copy_Folder {

	public static void main(String[] args) throws IOException {
		File srcFile=new File("d:\\a\\a");
		File descFile=new File("d:\\a\\d");   //destination
		copy(srcFile,descFile);
	}

	private static void copy(File srcFile, File descFile) throws IOException {
		descFile.mkdir();
		File[] listFiles=srcFile.listFiles();
		if(listFiles !=  null) {
			for(File file:listFiles) {
				if(file.isDirectory()) {
					File desc1=new File(descFile,file.getName());
					copy(file, desc1);
				}else {
					File desc1=new File(descFile,file.getName());
					copyFile(file,desc1);
				}
			}
		}
	}

	private static void copyFile(File srcFile, File descFile) throws IOException {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(descFile));
		byte[] by=new byte[1024];
		//int len=0;
		while(  (bis.read(by))  != -1) {
			bos.write(by);
		}
		bis.close();
		bos.close();
	}

}
