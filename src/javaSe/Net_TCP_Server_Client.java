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
 * TCP发送数据:
 * 创建Socket对象
 * 获取输出流写数据
 * 释放资源
 */
class Client{
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("MQW",8884);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//键盘输入
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//通道内的输出流是字节流包装成高效流
		String line=null;
		while(  (line=br.readLine()) != null) {
			if("888".equals(line)) {
				break;  //结束标记
			}
			 bw.write(line);
			 bw.newLine();		//
			 bw.flush();
		}
				
		/*OutputStream os= s.getOutputStream();//获取输出通道的流
		os.write("hello.tcp".getBytes());*/
		
		InputStream is=s.getInputStream();
		byte [] by=new byte[1024];  //读输入流
		int len=is.read(by); //阻塞
		String client =new String(by,0,len);
		System.out.println("client:"+client);
		//bw.close();  //不需要关闭
		//br.close();
		s.close();
	}
}
/*
 * 读取文本文件可以以null判断是否结束
 * 而通道内结束信息读取是通道流方法 shutdownOutput.
 * 
 * 在通道内的传输字节流需要flush();
 */
public class Net_TCP_Server_Client {
	public static void main(String[] args)  {
		//读取文本文件输出到服务器显示台
		// 创建Socket对象                     client 客户端
		/*Socket s = new Socket("MQW", 34567);
		// 封装文本文件
		BufferedReader br = new BufferedReader(new FileReader(
				"InetAddressDemo.java"));
		// 封装通道内的流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		s.shutdownOutput(); //自定义结束标记 上传完成
		
		//接收反馈
		BufferedReader brClient=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String client = brClient.readLine();
		System.out.println(client);
		
		br.close();
		s.close();*/
		
		// 创建服务器Socket对象       server服务端  upload
		/*ServerSocket ss = new ServerSocket(34567);
		// 监听客户端连接
		Socket s = ss.accept();
		// 封装通道内的流
		BufferedReader br = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		BufferedWriter bw= new BufferedWriter(new FileWriter("aa.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line+"保存在 aa.txt");  //想写到文本就创建文本输出流
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//反馈信息   通过通道
		BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bwServer.write("upload over");
		bwServer.newLine();
		bwServer.flush();
		
		bw.close();
		s.close();*/
		
		
	}
}
/*
 * tcp接收数据
 * 创建Socket
 * 监听客户端持续接收 ,监听客户端连接,返回一个对应的Socket对象
 * 获取输入流解析资源显示出来
 * 释放资源
 */
class Server{
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8884);  //端口
		Socket s=ss.accept();//监听
		//包装通道内输入流
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));//写入文本文件
		
		String line=null;
		while(  (line=br.readLine())  != null) {
			System.out.println(line+"\t保存在a.txt");
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		/*InputStream is=s.getInputStream();//获取输入流
		byte[] bys=new byte[1024];
		int len=is.read(bys);
		String str=new String(bys,0,len);
		String ip = s.getInetAddress().getHostAddress();//获取IP
		System.out.println(ip+":"+str);//输出显示
*/		
		OutputStream os=s.getOutputStream();//客户端输出反馈信息
		os.write("reveived it.".getBytes());
		bw.close();   //文件流需要关闭  通道流不需要关闭
		s.close();  //ss.close();不关闭
	}
}

