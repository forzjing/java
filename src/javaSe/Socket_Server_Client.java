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
			// �������׽���
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("***�ȴ��ͻ�������***");
			// ���������յ����׽��ֵ�����
			Socket socket = serverSocket.accept();
			// ��ȡ������
			InputStream is = socket.getInputStream();
			// ת����
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println("������������ �ͻ��˷��͵��ַ�Ϊ��" + str);
				br.readLine();
			}
			// �׽��ֵ����������ڡ�����ĩβ"
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
			print.write("��ð���������");
			print.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
