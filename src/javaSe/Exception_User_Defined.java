package javaSe;

public class Exception_User_Defined {

	public static void main(String[] args) {
		Bank bank=new Bank("aaa",1000);
		try {
			bank.userGetMoney("aaa", 10010);
		}catch(MyException e) {
			e.getMessage();
		}
	}
}

class Bank{
	int money;
	String user;
	Bank(){}
	Bank(String user,int money){
		this.money=money;this.user=user;
	}
	public void userGetMoney(String user,int num) throws MyException{
		if(user.equals(user)&&num>this.money){
			throw new MyException("no enough money");
		}else if(user.equals(user)&&num<=this.money) {
			money=this.money-num;
			System.out.println(user+"  getMoney  "+num+" at least "+money);			
		}
	}
}

class MyException extends Throwable{
	public MyException() {}
	public MyException(String s) {System.out.println(s);}
}