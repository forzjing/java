package javaSe;

import java.util.LinkedList;

public class Collection_LinkedList_Offer_Peek_Poll {

	public static void main(String[] args) {
		LinkedList<String> link=new LinkedList();
		link.add("ab1");
		link.add("ab2");
		link.add("ab3");
		link.add("ab4");
		link.offerFirst("ab10"); //���
		link.offerLast("ab10");
		System.out.println(link.peekFirst()); //��ȡ
		System.out.println(link.peekLast());
		System.out.println(link.pollFirst());//ɾ��
		System.out.println(link.pollLast());
		//ģ���ж�
		while(!link.isEmpty()) {
			System.out.println(link.pollFirst());
		}
		//ģ��ջ�ṹ
		while(!link.isEmpty()) {
			System.out.println(link.pollLast());
		}
	}

}
