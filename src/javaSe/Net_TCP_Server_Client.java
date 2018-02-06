package javaSe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

 

/*
 * TCP��������:
 * ����Socket����
 * ��ȡ�����д����
 * �ͷ���Դ
 */
class Client{
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("MQW",8884);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//��������
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//ͨ���ڵ���������ֽ�����װ�ɸ�Ч��
		String line=null;
		while(  (line=br.readLine()) != null) {
			if("888".equals(line)) {
				break;  //�������
			}
			 bw.write(line);
			 bw.newLine();		//
			 bw.flush();
		}
				
		/*OutputStream os= s.getOutputStream();//��ȡ���ͨ������
		os.write("hello.tcp".getBytes());*/
		
		InputStream is=s.getInputStream();
		byte [] by=new byte[1024];  //��������
		int len=is.read(by); //����
		String client =new String(by,0,len);
		System.out.println("client:"+client);
		//bw.close();  //����Ҫ�ر�
		//br.close();
		s.close();
	}
}
/*
 * ��ȡ�ı��ļ�������null�ж��Ƿ����
 * ��ͨ���ڽ�����Ϣ��ȡ��ͨ�������� shutdownOutput.
 * 
 * ��ͨ���ڵĴ����ֽ�����Ҫflush();
 */
public class Net_TCP_Server_Client {
	public static void main(String[] args)  {
		//��ȡ�ı��ļ��������������ʾ̨
		// ����Socket����                     client �ͻ���
		/*Socket s = new Socket("MQW", 34567);
		// ��װ�ı��ļ�
		BufferedReader br = new BufferedReader(new FileReader(
				"InetAddressDemo.java"));
		// ��װͨ���ڵ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		s.shutdownOutput(); //�Զ��������� �ϴ����
		
		//���շ���
		BufferedReader brClient=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String client = brClient.readLine();
		System.out.println(client);
		
		br.close();
		s.close();*/
		
		// ����������Socket����       server�����  upload
		/*ServerSocket ss = new ServerSocket(34567);
		// �����ͻ�������
		Socket s = ss.accept();
		// ��װͨ���ڵ���
		BufferedReader br = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		BufferedWriter bw= new BufferedWriter(new FileWriter("aa.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line+"������ aa.txt");  //��д���ı��ʹ����ı������
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//������Ϣ   ͨ��ͨ��
		BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bwServer.write("upload over");
		bwServer.newLine();
		bwServer.flush();
		
		bw.close();
		s.close();*/
		
		
	}
}
/*
 * tcp��������
 * ����Socket
 * �����ͻ��˳������� ,�����ͻ�������,����һ����Ӧ��Socket����
 * ��ȡ������������Դ��ʾ����
 * �ͷ���Դ
 */
class Server{
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8884);  //�˿�
		Socket s=ss.accept();//����
		//��װͨ����������
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));//д���ı��ļ�
		
		String line=null;
		while(  (line=br.readLine())  != null) {
			System.out.println(line+"\t������a.txt");
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		/*InputStream is=s.getInputStream();//��ȡ������
		byte[] bys=new byte[1024];
		int len=is.read(bys);
		String str=new String(bys,0,len);
		String ip = s.getInetAddress().getHostAddress();//��ȡIP
		System.out.println(ip+":"+str);//�����ʾ
*/		
		OutputStream os=s.getOutputStream();//�ͻ������������Ϣ
		os.write("reveived it.".getBytes());
		bw.close();   //�ļ�����Ҫ�ر�  ͨ��������Ҫ�ر�
		s.close();  //ss.close();���ر�
	}
}

