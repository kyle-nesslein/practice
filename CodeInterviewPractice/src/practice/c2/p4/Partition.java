package practice.c2.p4;

import practice.c2.Node;

public class Partition {
	public static void main(String args[]) {
		Node<Integer> head = new Node<Integer>(1);
		head.append(11);
		head.append(5);
		head.append(2);
		head.append(5);
		head.append(3);
		head.append(21);
		head.append(5);
		head.append(1);

		head = partition2(head, 4);

		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}	
	}
	
	public static <T> Node partition2(Node<T> node, int p) {
		Node<T> head = node, tail = node;
		
		while (node != null) {
			Node<T> next = node.next;
			if ((Integer) node.value < p) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
	public static <T> Node partition1(Node<T> head, int p) {
		Node<T> current = head;
		Node<T> lessHead = null, less = null;
		Node<T> greaterHead = null, greater = null;
		while (current != null) {
			if ((Integer) (current.value )< p) {
				if(less==null) {
					lessHead = current;
					less = current;
				} else {
					less.next = current;
					less = less.next;
				}
			} else {
				if(greater==null) {
					greaterHead = current;
					greater = current;
				} else {
					greater.next = current;
					greater = greater.next;
				}
			}
			current = current.next;
		}
		greater.next = null;
		less.next = greaterHead;
		return lessHead;
	}
}
