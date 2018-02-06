package javaSe;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDPЭ��������ݣ�
 * A:�������ն�Socket����
 * B:����һ�����ݰ�(��������)
 * C:����Socket����Ľ��շ�����������
 * D:�������ݰ�������ʾ�ڿ���̨
 * E:�ͷ���Դ
 */
//Address already in use:Cannot bind;
/*
 * UDPЭ�鷢�����ݣ�
 * A:�������Ͷ�Socket����
 * B:�������ݣ��������ݴ��
 * C:����Socket����ķ��ͷ����������ݰ�
 * D:�ͷ���Դ
 */
class Receive {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(12320); // ���ն�socket

		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by, by.length); // ��������

		ds.receive(dp); // ��������

		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(), 0, dp.getLength()); // ��������
		System.out.println("from " + ip + " data is: " + s);
	    ds.close();// �ͷ���Դ
	}
}

public class Net_UDP_send_receive {

	public static void main(String[] args) throws IOException {
		InetAddress i = InetAddress.getByName("MQW"); // ���Դ�����������ip��ַ
														// 192.168.0.1
		String name = i.getHostName();
		String ip = i.getHostAddress();
		System.out.println(name + "   " + ip);
	}
}

class Send {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();// ���Ͷ�socket

		byte[] by = "hallo.udp".getBytes();// ����
		DatagramPacket dp = new DatagramPacket(by, by.length, InetAddress.getByName("MQW"), 12320);
		// ����
		ds.send(dp);
		ds.close();// �ر�
	}
}
