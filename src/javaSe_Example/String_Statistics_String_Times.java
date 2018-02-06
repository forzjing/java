package javaSe_Example;

public class String_Statistics_String_Times {

	public static void main(String[] args) {
		String max = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
		String min = "java";

		System.out.println("times is :" + statistics(max, min));

	}
	
	private static int statistics(String max, String min) {
		int count = 0;
		int index = 0;
		while ((index = max.indexOf(min)) != -1) {
			count++;
			max = max.substring(index + min.length());
		}
		return count;
	}
}
