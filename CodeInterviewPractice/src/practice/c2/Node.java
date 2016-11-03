package practice.c2;

public class Node<T> {
	public Node<T> next;
	public T value;
	public Integer min;
	
	public Node(T val) {
		value = val;
	}
	
	public void append(T val) {
		if (next == null) {
			next = new Node<T>(val);
		} else {
			next.append(val);;
		}
	}
	
	Node delete(Node head, T val) {
		Node n = head;
		if (n.value.equals(val)) {
			return n.next;
		}
		while (n.next != null) {
			if (n.next.value.equals(val)) {
				n.next = n.next.next;
			}
			return n.next;
		}
		return null;
	}
}
