package javaSe_Example;

import java.io.File;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

class DeleteFolder extends TimerTask {
	public void run() {
		File srcFolder = new File("D:\\a");
		deleteFolder(srcFolder);
	}

	private void deleteFolder(File srcFolder) {
		File[] fileArray = srcFolder.listFiles();
		if (fileArray != null) {
			for (File file : fileArray) {
				if (file.isDirectory()) {
					deleteFolder(file);
				} else {
					System.out.println(file.getName() + " delete:" + file.delete());
				}
			}
			System.out.println(srcFolder.getName() + " delete:" + srcFolder.delete());
		}
	}
}

public class Timer_TimerTask_Boom {

	public static void main(String[] args) throws ParseException {
		// 指定时间打印
		Timer t = new Timer();
		/*
		 * t.schedule(new Task(t), 6000); //传入timer用来取消任务 t.schedule(new
		 * Task1(),1000,1000);
		 */
		// 指定时间删除文件夹
		String s = "2016-11-13 18:59:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(s);
		t.schedule(new DeleteFolder(), d);
		t.cancel();
	}

}

class Task1 extends TimerTask {
	public void run() {
		System.out.println("boom Task1");
	}
}

class Task extends TimerTask {
	private Timer t;

	public Task() {
	}

	public Task(Timer t) {
		this.t = t;
	}

	public void run() {
		System.out.println("boom");
		t.cancel(); // nullpointerException 需要传入timer来取消
	}
}