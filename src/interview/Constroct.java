package interview;

class First {

	public First(){
		a();
	}

	private void a() {
		// TODO
		System.out.println("one a");
	}
}
// one a second a
public class Constroct  extends First{

	public static void a(){
		System.out.println("second a");
	}
	public static void main(String[] args) {
		new Constroct();
		a();
	}
}
