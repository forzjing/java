package javaSe_Example;

import java.io.File;

public class File_DeleteSameFile_ChangeName {
	/*
	 * 删除重复文件
	 */
	public static void main(String[] args) {

		fileDelete("F:\\资料\\spring");
		//changeName("d:\\a");
	}
	private static void fileDelete(String s) {
		File f = new File(s);
		File[] files = f.listFiles();

		for (int x = 0; x < files.length - 1; x++) {
			for (int y = x + 1; y < files.length; y++) {
				if (files[y].length() == files[x].length()) {
					files[x].delete();
				}
			}
		}System.out.println("delete Ok");
	}
	/*
	 * 更改文件名
	 */
		private static void changeName(String string) {
			File file=new File("d:\\a");
			File[] f=file.listFiles();
			for (File singleFile  : f) {
				if(singleFile.isFile()) {
					String name=singleFile.getName();
					int index=name.indexOf(".");
					String newName1=name.substring(0,index);
					String newName2=".jpg";
					
					String target=newName1.concat(newName2);
					File newFile=new File(file,target);
					
					singleFile.renameTo(newFile);
				}
			}System.out.println("change name ok");
		}
}
