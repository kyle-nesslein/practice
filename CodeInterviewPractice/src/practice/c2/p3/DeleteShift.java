package practice.c2.p3;

import practice.c2.Node;

public class DeleteShift {
	public static void main(String args[]) {
		Node<Integer> head = new Node<Integer>(1);
		head.append(5);
		head.append(2);
		head.append(5);
		head.append(3);
		head.append(5);
		delete(head.next.next.next);

		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static <T> void delete(Node<T> node) {
		Node<T> prev = node;
		while(node.next != null) {
			node.value = node.next.value;
			prev = node;
			node = node.next;
		}
		prev.next = null;
	}
}
