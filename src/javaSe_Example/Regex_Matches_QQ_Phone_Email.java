package javaSe_Example;

public class Regex_Matches_QQ_Phone_Email {

	public static void main(String[] args) {
		String s="271970127";
		System.out.println(s.matches("[^0][0-9]{4,9}"));
		
		s="13000000000";
		System.out.println(s.matches("1[34578]\\d{9}"));
		
		s="xyz@abc.com";
		System.out.println(s.matches("\\w+@\\w{2,10}(\\.\\w{2,5})+"));
		//[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,6}\\.[a-zA-z_0-9]{2,3};
		
		String num="876314520";
		if(num.startsWith("0")){
			System.out.println('0');
			return;
		}
		if(num.length()<5||num.length()>11){
			System.out.println("wrong length");
			return ;
		}
		if(num.contains("tecent")){
			System.out.println("tecent");
			return;
		}
		// ÊÇ·ñÊÇÊý×Ö
		char[] ch=num.toCharArray();
		for(int x=0;x<ch.length;x++){
			char chs=ch[x];
			if(!Character.isDigit(chs)){
				System.out.println("need number");
				return;
			}
		}
		System.out.println("right");
	}

}
