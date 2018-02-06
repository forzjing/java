package complex;

public class Temp {

	private static void change(String s,StringBuffer sb)
	{
		s="aaaa";
		sb.setLength(0);
		sb.append("aaaa");
	}
	public static void main(String[] args) {
		String s="bbbb";
		StringBuffer sb=new StringBuffer("bbbb");
		change(s,sb);
		System.out.println(s+sb);
	}
}


