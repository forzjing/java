package javaSe_Example;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_Frame_Input {

	public static void main(String[] args) {
		Frame f=new Frame("input number");
		f.setBounds(400,400,400,400);
		f.setLayout(new FlowLayout());
		/*public void setBounds(int x, int y, int width, int height)
		�ƶ�������������С���� x �� y ָ�����Ͻǵ���λ�ã�
		�� width �� height ָ���µĴ�С�� ��� width ֵ�� height 
		ֵС��֮ǰ���� setMinimumSize ָ������С��С��������ֵ���Զ����ӡ�*/ 
		Label label=new Label("input number no char");
		TextField tf=new TextField(40);
		f.add(label);
		f.add(tf);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char ch=e.getKeyChar();
				if(! (ch>='0'&&ch<='9')) {
					e.consume();
				}
			}
		});
		f.setVisible(true);
	}

}
