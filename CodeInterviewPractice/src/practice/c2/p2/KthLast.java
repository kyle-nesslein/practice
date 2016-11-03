package practice.c2.p2;

import practice.c2.Node;

public class KthLast {
	public static void main(String args[]) {
		Node<Integer> head = new Node<Integer>(1);
		head.append(5);
		head.append(2);
		head.append(5);
		head.append(3);
		head.append(5);	
		System.out.println(getKthLast(head, 7).value);
	}
	
	public static <T> Node<T> getKthLast(Node<T> head, int k) {
		Node<T> first = head;
		while (first.next != null && k > 1) {
			first = first.next;
			k--;
		}
		Node<T> kth = head;
		while (first.next!=null) {
			first = first.next;
			kth = kth.next;
		}
		return kth;
	}

}
