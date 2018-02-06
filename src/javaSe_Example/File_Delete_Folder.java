package javaSe_Example;

import java.io.File;

public class File_Delete_Folder {

	public static void main(String[] args) {
		File file=new File("D:\\a");
		deleteFolder(file);
	}
	
	private static void deleteFolder(File srcFolder) {
		File[] fileArray = srcFolder.listFiles();
		if (fileArray != null) {
			for (File file : fileArray) {
				if (file.isDirectory()) {
					deleteFolder(file);
				} else {
					System.out.println(file.getName() + " delete:" + file.delete());
				}
			}
			System.out.println(srcFolder.getName() + " delete:" + srcFolder.delete());
		}
	}

}
