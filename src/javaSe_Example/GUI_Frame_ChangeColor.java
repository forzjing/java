package javaSe_Example;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_Frame_ChangeColor {

	public static void main(String[] args) {
		final Frame f=new Frame("change color");
		f.setBounds(400,200,400,300);
		f.setLayout(new FlowLayout());
		
		Button redButton=new Button("red");
		Button greenButton=new Button("green");
		Button blueButton=new Button("blue");
		
		f.add(redButton);
		f.add(greenButton);
		f.add(blueButton);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
			/*	 对按钮添加动作事件
				 redButton.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
				 f.setBackground(Color.RED);
				 }
				 });*/
			/* 对按钮添加鼠标点击事件
				 redButton.addMouseListener(new MouseAdapter() {
				 @Override
				 public void mouseClicked(MouseEvent e) {
				 f.setBackground(Color.RED);
				 }
				 });*/
		redButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				f.setBackground(Color.RED);
			}
		});
		redButton.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				f.setBackground(Color.WHITE);
			}
		});
		greenButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				f.setBackground(Color.GREEN);
			}
		});
		greenButton.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				f.setBackground(Color.WHITE);
			}
		});
		blueButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				f.setBackground(Color.BLUE);
			}
		});
		blueButton.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				f.setBackground(Color.WHITE);
			}
		});
		f.setVisible(true);
	}
}
