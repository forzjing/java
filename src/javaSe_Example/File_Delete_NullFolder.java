package javaSe_Example;

import java.io.File;

public class File_Delete_NullFolder {

	public static void main(String[] args) {
		File file=new File("d:\\a\\a");
		ergodicDelete(file);
	}
	// 空目录的上一级空目录无法删除
	private static void ergodicDelete(File file) {
		File[] listFiles= file.listFiles();
		
		if(listFiles.length==0) {
			file.delete();
		}else {
			for(File f: listFiles) {
				if(f.isDirectory()) {
					ergodicDelete(f);
					file.delete();//遍历删除之后再删除一次上级目录可以
				}/*else {
					f.delete();
				}*/
			}
		}
	}

}
