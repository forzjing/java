package javaSe_Example;

import java.io.File;

public class File_Delete_NullFolder {

	public static void main(String[] args) {
		File file=new File("d:\\a\\a");
		ergodicDelete(file);
	}
	// ��Ŀ¼����һ����Ŀ¼�޷�ɾ��
	private static void ergodicDelete(File file) {
		File[] listFiles= file.listFiles();
		
		if(listFiles.length==0) {
			file.delete();
		}else {
			for(File f: listFiles) {
				if(f.isDirectory()) {
					ergodicDelete(f);
					file.delete();//����ɾ��֮����ɾ��һ���ϼ�Ŀ¼����
				}/*else {
					f.delete();
				}*/
			}
		}
	}

}
