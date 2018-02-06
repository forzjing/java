package javaSe;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_Frame_ {

	public static void main(String[] args) {
		Frame f=new Frame("hallo");
		//f.setSize(400,400);
		//f.setSize(new Dimension(200,200));
		//f.setLocation(400,200);
		//f.setLocation(new Point(100,200));
		//f.setTitle("hallo jaba");
		f.setBounds(100,100,200,200);
		f.setLayout(new FlowLayout());
		
		final TextField tf=new TextField(20);
		Button bu=new Button("move");
		final TextArea ta=new TextArea(10,40);
		
		//������
		f.add(tf);
		f.add(bu);
		f.add(ta);
		
		//��������
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});  //WindowAdapter ʵ��WindowListener
		//��ť����¼�
		bu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tf_str=tf.getText().trim();
				tf.setText("");  //�������
				ta.append(tf_str+"\r\n");
				tf.requestFocus();// ��ȡ���
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//��ʾ����	
		f.setVisible(true);
		
	}

}
