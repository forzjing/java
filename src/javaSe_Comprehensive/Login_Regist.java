package javaSe_Comprehensive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login_Regist {

	public static void main(String[] args) {
		while (true) {
			System.out.println("welcome");
			System.out.println("1:login");
			System.out.println("2:regist");
			System.out.println("3:exit");
			System.out.println("input your choice");
			Scanner sc = new Scanner(System.in);
			String choiceString = sc.nextLine();
			UserDao ud = new UserDaoImpl();

			switch (choiceString) {
			case "1":
				System.out.println("login");
				System.out.println("input username:");
				String username = sc.nextLine();
				System.out.println("input password");
				String password = sc.nextLine();

				boolean flag = ud.isLogin(username, password);
				if (flag) {
					System.out.println("success you can play guessNumber");
					System.out.println(" do you play ? Y/N");
					while (true) {
						String resultString = sc.nextLine();
						if (resultString.equalsIgnoreCase("y")) {
							GuessNumber.start();
							System.out.println("play again? Y/N");
						} else {
							break;
						}
					}
					System.out.println("goodbye welcome again");
					System.exit(0);
				} else {
					System.out.println(" username or password is wrong");
				}
				break;
			case "2":
				System.out.println("regist");
				System.out.println("input your name:");
				String newUsername = sc.nextLine();
				System.out.println("input your password");
				String newPassword = sc.nextLine();

				User user = new User();
				user.setUsername(newUsername);
				user.setPassword(newPassword);

				ud.regist(user);
				System.out.println("regist ok");
				break;
			case "3":
			default:
				System.out.println("Thanks welcome again");
				System.exit(0);
				break;
			}
		}
	}

}

interface UserDao {
	public abstract boolean isLogin(String username, String password);

	public abstract void regist(User user);
}

class User {
	private String username;
	private String password;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

class UserDaoImpl implements UserDao {
	private static File file = new File("user.txt");
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("creatNewFile fail");
		}
	}

	public boolean isLogin(String username, String password) {
		boolean flag = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datas = line.split("=");
				if (datas[0].equals(username) && datas[1].equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("can't found Userfile");
		} catch (IOException e) {
			System.out.println("login fail");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("IO close fail");
				}
			}
		}
		return flag;
	}

	public void regist(User user) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(user.getUsername() + "=" + user.getPassword());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("regist fail");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("IO close fail");
				}
			}
		}
	}
}

class GuessNumber {
	private GuessNumber() {
	}

	public static void start() {
		int number = (int) (Math.random() * 100) + 1;
		int count = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("input 1-100");
			int guessNumber = sc.nextInt();
			count++;
			if (guessNumber > number) {
				System.out.println("your number is bigger than trueNumber");
			} else if (guessNumber < number) {
				System.out.println("your number is smaller than trueNumber");
			} else {
				System.out.println("right you guess right on " + count + " times");
				break;
			}
		}
	}
}
