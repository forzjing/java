package complex;
import java.io.*;
/**
 * 文件分割类
 * @author la
 *
 */
import java.io.*;
/**
 * 文件合并
 * @author la
 *
 */
 class LinkFile {
	public String fileName=null;
	public String targetDir=null;
	public int linkFIle()throws Exception {
		//得到小文件数
		int count=0;
		try {
			File countFile=new File(this.fileName);
			FileReader fReader=new FileReader(countFile);
			BufferedReader bReader=new BufferedReader(fReader);
			bReader.mark(1);
			count=Integer.parseInt(bReader.readLine());
			bReader.close();
		} catch (Exception e) {
			throw e;
		}
		//还原文件名和目录名
		String oldFileName=null;
		String countFileDir=null;
		try {
			String countFileName=new File(this.fileName).getName();
			countFileDir=fileName.substring(0, this.fileName.lastIndexOf(countFileName)).replace('\\', '/');
			oldFileName=countFileName.substring(0, countFileName.length()-6);
		} catch (Exception e) {
			throw e;
		}
		//合并小文件
		FileInputStream fis=null;
		byte[] data=null;
		try {
			FileOutputStream fos=new FileOutputStream(this.targetDir+oldFileName);
			for (int i = 1; i <=count; i++) {
				fis=new FileInputStream(countFileDir+oldFileName+"_"+i);
				data=new byte[fis.available()];
				fis.read(data);
				fis.close();
				fos.write(data);
			}
			fos.close();
		} catch (Exception e) {
			throw e;
		}
		return count;
	}
}
 
 
 public class CutFile {
		
		public CutFile() {
			super();
		}
		public String fileName=null;
		public long unitSize=0;//每个小文件的大小
		public String targetDir=null;//分割后小文件所在的文件夹
		public int cutFile() throws Exception{
			File file=new File(fileName);
			long size=file.length();//总字节数
			int count=0;//小文件数
			long pos=0;//当前位置
			long last=0;//剩余字节数
			DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(file), (int )unitSize));
			byte[] databuf=new byte[(int)unitSize];
			while(pos<size)
			{
				count ++;
				last=size-pos;
				if(last<unitSize)
					databuf=new byte[(int)last];
				dis.read(databuf);
				System.out.println("count="+count+";pos="+pos+";databuf.length="+databuf.length);
				pos=pos+databuf.length;
				//写小文件
				try {
					RandomAccessFile raFile=new RandomAccessFile(targetDir+file.getName()+"_"+count, "rw");
					raFile.write(databuf);
					raFile.close();
				} catch (Exception e) {
					throw e;
				}
			}
			//记载小文件数
			File file1=new File(targetDir+file.getName()+"_count");
			FileWriter fWriter=new FileWriter(file1);
			BufferedWriter bWriter=new BufferedWriter(fWriter);
			String string=(new Integer(count)).toString();
			bWriter.write(string, 0, string.length());
			bWriter.flush();
			bWriter.close();
			return count;
		}
	}
	 