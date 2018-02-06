package javaSe_Example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
 

public class File_Copy_Rename_Selover2 {
	static int x = 0;

	public static void main(String[] args) throws IOException {
		File file1 = new File("F:\\fq1\\讲师-闫洪波(68F728DFCA07)\\DemoJavaWeb2\\PPT");
		File file2 = new File("F:\\fq1\\讲师-闫洪波(68F728DFCA07)\\DemoJavaWeb2\\PPT1");
		ergodicCopy(file1, file2);
		System.out.println("ok");
	}

	private static void ergodicCopy(File file, File tarFile) throws IOException {
		File[] listFiles = file.listFiles();
		BufferedOutputStream bos;
		if (listFiles != null) {
			for (File file2 : listFiles) {
				if (file2.isDirectory()) {
					ergodicCopy(file2, tarFile);
					x++;// 有问题文件多了会缺失文件
				} else if( file2.getName().endsWith(".ppt") ) { //if ( file2.getName().endsWith(".bmp"))
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file2));
					File result = new File(tarFile, file2.getName());
					if (result.exists()) {
						int dot = file2.getName().lastIndexOf(".");
						StringBuffer sb = new StringBuffer(file2.getName());
						StringBuffer insert = sb.insert(dot, x);
						result = new File(tarFile, insert.toString());
					}
					bos = new BufferedOutputStream(new FileOutputStream(result));
					byte[] by = new byte[1024];
					int len = 0;  
					while ((len = bis.read( by)) != -1) {
						bos.write(by, 0, len);
					}
					bos.close();
					bis.close();
					// System.out.println(result);
				}
			}
		}
	}
}
