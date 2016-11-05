package practice.c3.p2;

import practice.c2.Node;

public class Stack {
	Node<Integer> top;

	public void push (Integer item) {
		Node<Integer> node = new Node<Integer>(item);
		node.next = top;
		top = node;
		if (top.next == null) {
			top.min = top.value;
		} else {
			if (top.value < top.next.min){
				top.min = top.value;
			} else {
				top.min = top.next.min;
			}
			
		}
	}
	
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Node<Integer> pop() {
		Node<Integer> node = top;
		top = top.next;
		return node;
	}
	
	public Node<Integer> peek() {
		return top;
	}
	
	public Integer min() {
		return top.min;
	}
	
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(4);
		s.push(6);
		s.push(8);
		s.push(3);
		s.push(4);
		s.push(2);
		
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
	}
}
