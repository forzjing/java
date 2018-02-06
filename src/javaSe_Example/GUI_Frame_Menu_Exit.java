package javaSe_Example;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GUI_Frame_Menu_Exit {

	public static void main(String[] args) {
		Frame f=new Frame("1level");
		
		f.setBounds(400,200,400,300);
		f.setLayout(new FlowLayout());
		
		MenuBar menuBar=new MenuBar();
		Menu menu=new Menu("file");
		MenuItem menuItem=new MenuItem("exit system");
		
		menuBar.add(menu);
		menu.add(menuItem);
		
		f.setMenuBar(menuBar);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
}

class Exit_Mulitiple{
	public static void main(String[] args) {
		final Frame f=new Frame("mul level");
		f.setBounds(400,200,400,300);
		f.setLayout(new FlowLayout());
		final String name=f.getTitle();
		
		MenuBar mb=new MenuBar();
		Menu m1=new Menu("file");
		Menu m2=new Menu("change name");
		final MenuItem mi1=new MenuItem("study hard");
		final MenuItem mi2=new MenuItem("daday up");
		MenuItem mi3= new MenuItem("huifu Title");
		MenuItem mi4= new MenuItem("open txt");
		MenuItem mi5= new MenuItem("exit");
		
		m2.add(mi1);
		m2.add(mi2);
		m2.add(mi3);
		
		m1.add(m2);
		m1.add(mi4);
		m1.add(mi5);
		
		mb.add(m1);
		f.setMenuBar(mb);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		mi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setTitle(mi1.getLabel());
			}
		});
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setTitle(mi2.getLabel());
			}
		});
		
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setTitle(name);
			}
		});
		
		mi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime r=Runtime.getRuntime();
				try {
					r.exec("notepad");
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
}
