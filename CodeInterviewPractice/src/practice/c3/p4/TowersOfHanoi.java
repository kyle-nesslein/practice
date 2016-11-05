package practice.c3.p4;

import practice.c2.Node;
import practice.c3.p2.Stack;

public class TowersOfHanoi {
	Tower t1, t2, t3;
	
	static public void main(String args[]) {
		final int SIZE = 10;
		TowersOfHanoi towers = new TowersOfHanoi(SIZE);
		towers.print();
		towers.t1.moveDisks(SIZE, towers.t3, towers.t2);
		towers.print();
	}
	
	public TowersOfHanoi(int size) {
		t1 = new Tower(size);
		t2 = new Tower(size);
		t3 = new Tower(size);
		for (int i = size; i > 0; i--) {
			t1.add(new Node<Integer>(i));
		}
	}
	
	public void solve(Stack t1, Stack t2, Stack t3) {
	}
	
	public void print() {
		t1.print();
		t2.print();
		t3.print();
	}
	
	public class Tower {
		Stack s;
		int index;
		
		public Tower(int i) {
			s = new Stack();
			index = i;
		}
		
		public void add(Node<Integer> disk) {
			if (s.peek() != null && disk.value > s.peek().value){ 
				System.out.println("Disk placement error: " + disk.value); 
			} else {
				s.push(disk.value);
			}
		}
		
		public void moveTopTo(Tower t) {
			t.add(s.pop());
		}
		
		public void moveDisks(int n, Tower dest, Tower buf) {
			if (n > 0) {
				moveDisks(n-1, buf, dest);
				moveTopTo(dest);
				buf.moveDisks(n-1, dest, this);
			}
		}
		
		public void print() {
			StringBuffer sb = new StringBuffer();
			Node<Integer> current = s.peek();
			sb.append("T:");
			while (current != null) {
				sb.append(current.value);
				sb.append("-");
				current = current.next;
			}
			System.out.println(sb.toString());
		}
	}
}
