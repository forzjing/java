package javaSe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket_Server_Client {

	public static void main(String[] args) {

		try {
			// 服务器套接字
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("***等待客户端链接***");
			// 监听并接收到此套接字的连接
			Socket socket = serverSocket.accept();
			// 获取输入流
			InputStream is = socket.getInputStream();
			// 转换流
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println("服务器描述： 客户端发送的字符为：" + str);
				br.readLine();
			}
			// 套接字的输入流置于“流的末尾"
			socket.shutdownInput();
			br.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Socket_Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			OutputStream os = socket.getOutputStream();
			PrintWriter print = new PrintWriter(os);
			print.write("你好啊！服务器");
			print.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
