package javaSe;

public class Design_Mode_Adapter {

	public static void main(String[] args) {
		// 通过抽象类实现接口
		// 通过具体类实现抽象类间接实现接口可以不必覆写接口全部功能
	}

}

class UserDaoImpl extends UserAdapter {
	@Override
	public void add() {
		System.out.println("添加功能");
	}
}

interface UserDao {
	public abstract void add();

	public abstract void delete();

	public abstract void update();

	public abstract void find();
}

abstract class UserAdapter implements UserDao {

	@Override
	public void add() {
	}

	@Override
	public void delete() {
	}

	@Override
	public void update() {
	}

	@Override
	public void find() {
	}

}