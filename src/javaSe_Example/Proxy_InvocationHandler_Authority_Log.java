package javaSe_Example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DiyInvocationHandler implements InvocationHandler {
	private Object target;

	public DiyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("FunctionInterface use InvocationHandler Instance invoke proxy it's function");
		Object result = method.invoke(target, args);
		System.out
				.println("InvocationHandler Instance receive FunctionInterface add limits of authority record log \r");
		return result; // 代理的对象 的方法的结果
	}
}

public class Proxy_InvocationHandler_Authority_Log {

	public static void main(String[] args) {
		FunctionInterface f = new Function();
		f.add();
		f.delete();
		f.update();
		f.find();
		System.out.println("-----------------");

		DiyInvocationHandler handler = new DiyInvocationHandler(f); // 对谁做代理,传谁
		FunctionInterface proxyFunction = (FunctionInterface) Proxy.newProxyInstance(f.getClass().getClassLoader(),
				f.getClass().getInterfaces(), handler);
		// 参数顺序 ,类加载器,所有的接口对象, InvocationHandler的实现类对象
		// 返回代理对象 是原对象的多态
		proxyFunction.add();
		proxyFunction.delete();
		proxyFunction.update();
		proxyFunction.find();
		System.out.println("---------------代理成功ok");

		UserDaoImple ud = new UserDaoImple();
		handler = new DiyInvocationHandler(ud);
		UserDao proxyUser = (UserDao) Proxy.newProxyInstance(ud.getClass().getClassLoader(),
				ud.getClass().getInterfaces(), handler);
		proxyUser.login();
		proxyUser.regist();
		System.out.println("---------------ok");
	}

}

interface FunctionInterface { // UserDao //UserDaoImple
	public abstract void add();

	public abstract void delete();

	public abstract void update();

	public abstract void find();
}

class Function implements FunctionInterface {
	public void add() {
		System.out.println("add");
	}

	public void delete() {
		System.out.println("delete");
	}

	public void update() {
		System.out.println("update");
	}

	public void find() {
		System.out.println("find");
	}
}

interface UserDao {
	public static final String a = "a";

	public abstract void regist();

	public abstract void login();
}

class UserDaoImple implements UserDao {

	@Override
	public void regist() {
		System.out.println("regist");
	}

	@Override
	public void login() {
		System.out.println("login");
	}

}