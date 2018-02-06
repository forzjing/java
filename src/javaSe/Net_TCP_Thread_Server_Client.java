package javaSe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class UserThread implements Runnable {
	private Socket s;

	public UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			// ��װͨ���ڵ���
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// ��װ�ı��ļ�
			// BufferedWriter bw = new BufferedWriter(new
			// FileWriter("Copy.java"));

			// Ϊ�˷�ֹ���Ƴ�ͻ
			String newName = System.currentTimeMillis() + ".java";
			BufferedWriter bw = new BufferedWriter(new FileWriter(newName));

			String line = null;
			while ((line = br.readLine()) != null) { // ����
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
			// ��������
			BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bwServer.write("�ļ��ϴ��ɹ�");
			bwServer.newLine();
			bwServer.flush();
			// �ͷ���Դ
			bw.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UploadServer {
	public static void main(String[] args) throws IOException {
		// ����������Socket����
		ServerSocket ss = new ServerSocket(11111);

		while (true) {
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}
}

public class Net_TCP_Thread_Server_Client {

	public static void main(String[] args) {
		 // �ϴ��ļ���ÿ���ͻ�����һ���߳�
	}

}

class UploadClient {
	public static void main(String[] args) throws IOException {
		// �����ͻ���Socket����
		Socket s = new Socket("MQW", 11111);

		// ��װ�ı��ļ�
		// BufferedReader br = new BufferedReader(new FileReader(
		// "InetAddressDemo.java"));
		BufferedReader br = new BufferedReader(new FileReader("ReceiveDemo.java"));
		// ��װͨ������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		String line = null;
		while ((line = br.readLine()) != null) { // ����
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		// Socket�ṩ��һ����ֹ������֪ͨ�����������ˣ���û�����ݹ�����
		s.shutdownOutput();
		// ���շ���
		BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String client = brClient.readLine(); // ����
		System.out.println(client);

		// �ͷ���Դ
		br.close();
		s.close();
	}
}
