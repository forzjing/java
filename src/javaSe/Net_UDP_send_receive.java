package javaSe;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDP协议接收数据：
 * A:创建接收端Socket对象
 * B:创建一个数据包(接收容器)
 * C:调用Socket对象的接收方法接收数据
 * D:解析数据包，并显示在控制台
 * E:释放资源
 */
//Address already in use:Cannot bind;
/*
 * UDP协议发送数据：
 * A:创建发送端Socket对象
 * B:创建数据，并把数据打包
 * C:调用Socket对象的发送方法发送数据包
 * D:释放资源
 */
class Receive {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(12320); // 接收端socket

		byte[] by = new byte[1024];
		DatagramPacket dp = new DatagramPacket(by, by.length); // 创建包裹

		ds.receive(dp); // 接收数据

		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(), 0, dp.getLength()); // 解析数据
		System.out.println("from " + ip + " data is: " + s);
	    ds.close();// 释放资源
	}
}

public class Net_UDP_send_receive {

	public static void main(String[] args) throws IOException {
		InetAddress i = InetAddress.getByName("MQW"); // 可以传入主机名或ip地址
														// 192.168.0.1
		String name = i.getHostName();
		String ip = i.getHostAddress();
		System.out.println(name + "   " + ip);
	}
}

class Send {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();// 发送端socket

		byte[] by = "hallo.udp".getBytes();// 包裹
		DatagramPacket dp = new DatagramPacket(by, by.length, InetAddress.getByName("MQW"), 12320);
		// 发送
		ds.send(dp);
		ds.close();// 关闭
	}
}
