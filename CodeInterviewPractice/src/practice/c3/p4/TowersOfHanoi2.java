package practice.c3.p4;

import practice.c2.Node;
import practice.c3.p2.Stack;

public class TowersOfHanoi2 {

	public class Tower{
		Stack s;
		
		public void add(Integer disk) {
			if (s.peek() != null && disk > s.peek().value) {
				System.out.println("Disk move failure");
			} else {
				s.push(disk);
			}
		}
		
		public void moveTop(Tower dest) {
			dest.add(s.pop().value);
		}
		
		public void moveDisks(int n, Tower dest, Tower buf) {
			if(n > 0) {
				moveDisks(n-1,buf,dest);
				moveTop(dest);
				buf.moveDisks(n-1,dest,this);
			}
		}
		
	}
}
