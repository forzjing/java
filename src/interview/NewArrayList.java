package interview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewArrayList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final List<String> NAMES = new ArrayList<String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add("Perfect1");
		add("Perfect2");
		String str=get(1);
		System.out.println(str);
		System.out.println(NAMES);
	}};
	public static void main(String[] args) {
		System.out.println(NAMES);
	}

}
