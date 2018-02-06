package javaSe_Example;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class File_listFiles_Ergodic_Folder_GetPath {

	public static void main(String[] args) {
		File file = new File("d:\\a");
		//使用遍历文件夹
		ergodicFolder(file);
		
		System.out.println("----------------------");
		File srcFolder = new File("d:\\a");
		// 递归功能实现
		getAllJavaFilePaths(srcFolder);
	}

	private static void ergodicFolder(File file) {
		File[] files = file.listFiles();
		for (File subFilePath : files) {
			if (subFilePath.isDirectory()) {
				ergodicFolder(subFilePath);
				System.out.println(subFilePath);
			}else if(subFilePath.isFile()) {  //else if(subFilePath.getName().endsWith(".txt");
				System.out.println(subFilePath);
			}
		}
	}
	
	
	private static void getAllJavaFilePaths(File srcFolder) {
		// 获取该目录下所有的文件或者文件夹的File数组
		File[] fileArray = srcFolder.listFiles();

		// 遍历该File数组，得到每一个File对象
		for (File file : fileArray) {
			// 判断该File对象是否是文件夹
			if (file.isDirectory()) {
				getAllJavaFilePaths(file);
			} else {
				// 继续判断是否以.java结尾
				if (file.getName().endsWith(".java")) {
					// 就输出该文件的绝对路径
					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}
}
