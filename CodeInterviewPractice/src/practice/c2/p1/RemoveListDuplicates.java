package practice.c2.p1;
import java.util.HashSet;

import practice.c2.Node;

public class RemoveListDuplicates {
	public static void main(String args[]) {
		Node<Integer> head = new Node<Integer>(1);
		head.append(5);
		head.append(2);
		head.append(5);
		head.append(3);
		head.append(5);
		removeDuplicates(head);

		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static <T> void removeDuplicates(Node<T> n) {
		HashSet<T> hash = new HashSet<T>();
		Node<T> prev = null;

		while(n != null) {
			if(hash.contains(n.value)) {
				prev.next = n.next;
			} else {
				hash.add(n.value);
				prev = n;
			}
			n = n.next;
		}
	}
}