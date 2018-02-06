package complex;
import java.io.*;
/**
 * �ļ��ָ���
 * @author la
 *
 */
import java.io.*;
/**
 * �ļ��ϲ�
 * @author la
 *
 */
 class LinkFile {
	public String fileName=null;
	public String targetDir=null;
	public int linkFIle()throws Exception {
		//�õ�С�ļ���
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
		//��ԭ�ļ�����Ŀ¼��
		String oldFileName=null;
		String countFileDir=null;
		try {
			String countFileName=new File(this.fileName).getName();
			countFileDir=fileName.substring(0, this.fileName.lastIndexOf(countFileName)).replace('\\', '/');
			oldFileName=countFileName.substring(0, countFileName.length()-6);
		} catch (Exception e) {
			throw e;
		}
		//�ϲ�С�ļ�
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
		public long unitSize=0;//ÿ��С�ļ��Ĵ�С
		public String targetDir=null;//�ָ��С�ļ����ڵ��ļ���
		public int cutFile() throws Exception{
			File file=new File(fileName);
			long size=file.length();//���ֽ���
			int count=0;//С�ļ���
			long pos=0;//��ǰλ��
			long last=0;//ʣ���ֽ���
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
				//дС�ļ�
				try {
					RandomAccessFile raFile=new RandomAccessFile(targetDir+file.getName()+"_"+count, "rw");
					raFile.write(databuf);
					raFile.close();
				} catch (Exception e) {
					throw e;
				}
			}
			//����С�ļ���
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
	 