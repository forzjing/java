package javaSe;

public class Design_Mode_Adapter {

	public static void main(String[] args) {
		// ͨ��������ʵ�ֽӿ�
		// ͨ��������ʵ�ֳ�������ʵ�ֽӿڿ��Բ��ظ�д�ӿ�ȫ������
	}

}

class UserDaoImpl extends UserAdapter {
	@Override
	public void add() {
		System.out.println("��ӹ���");
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