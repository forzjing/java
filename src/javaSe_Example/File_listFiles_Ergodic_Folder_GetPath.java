package javaSe_Example;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class File_listFiles_Ergodic_Folder_GetPath {

	public static void main(String[] args) {
		File file = new File("d:\\a");
		//ʹ�ñ����ļ���
		ergodicFolder(file);
		
		System.out.println("----------------------");
		File srcFolder = new File("d:\\a");
		// �ݹ鹦��ʵ��
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
		// ��ȡ��Ŀ¼�����е��ļ������ļ��е�File����
		File[] fileArray = srcFolder.listFiles();

		// ������File���飬�õ�ÿһ��File����
		for (File file : fileArray) {
			// �жϸ�File�����Ƿ����ļ���
			if (file.isDirectory()) {
				getAllJavaFilePaths(file);
			} else {
				// �����ж��Ƿ���.java��β
				if (file.getName().endsWith(".java")) {
					// ��������ļ��ľ���·��
					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}
}
