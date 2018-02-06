package javaSe_Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class File_Copy_Rename_Selover {
	static int x = 0;

	public static void main(String[] args) throws IOException {
		File file1 = new File("D:\\微云同步盘\\picture\\leg");
		File file2 = new File("D:\\微云同步盘\\picture\\leg1");
		ergodicCopy(file1, file2);
		System.out.println("ok");
	}

	private static void ergodicCopy(File file, File tarFile) throws IOException {
		File[] listFiles = file.listFiles();
		BufferedWriter bw = null;
		if (listFiles != null) {
			for (File file2 : listFiles) {
				if (file2.isDirectory()) {
					ergodicCopy(file2, tarFile);
					x++;
				} else if ( file2.getName().endsWith(".java")) {
					BufferedReader br = new BufferedReader(new FileReader(file2));
					File result = new File(tarFile, file2.getName());
					if (result.exists()) {
						int dot = file2.getName().lastIndexOf(".");
						StringBuffer sb = new StringBuffer(file2.getName());
						StringBuffer insert = sb.insert(dot, x);
						result = new File(tarFile, insert.toString());
					}
					bw = new BufferedWriter(new FileWriter(result));
					char[] ch = new char[1024];
					int len = 0;
					while ((len = br.read(ch)) != -1) {
						bw.write(ch, 0, len);
					}
					bw.close();
					br.close();
					// System.out.println(result);
				}
			}
		}
	}

	private static void copy(String src, String tar) throws IOException {
		File srcPath = new File(src);
		File tarPath = new File(tar);
		BufferedWriter bw = new BufferedWriter(new FileWriter(tarPath));
		BufferedReader br = new BufferedReader(new FileReader(srcPath));
		char[] ch = new char[1024 * 3];
		int len = 0;
		while ((len = br.read(ch)) != -1) {
			bw.write(ch, 0, len);
			bw.flush();
		}
		br.close();
		bw.close();
	}

	private static List<String> ergodic(File file) throws IOException {
		File[] listFiles = file.listFiles();
		List<String> list = null;
		if (listFiles != null) {
			for (File file2 : listFiles) {
				if (file2.isDirectory()) {
					ergodic(file2);
				} else if (file2.getName().endsWith(".txt")) {
					// System.out.println(file2);
					list.add(file2.getAbsolutePath());
				}
			}
		}
		return list;
	}

}
