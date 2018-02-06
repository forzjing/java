package javaSe_Example;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class FileSequenceInputStream_MergeFiles {

	public static void main(String[] args) throws IOException {

		Vector<InputStream> v = new Vector<>();
		File file = new File("D:\\KEPLER");
		File[] listFiles = file.listFiles();
		for (File target : listFiles) {
			v.add(new FileInputStream(target));
		}
		Enumeration<InputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\×Ü½á.java"));
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = sis.read(b)) != -1) {
			bos.write(b, 0, len);
		}

		bos.close();
		sis.close();
		System.out.println("ok");
	}
}
