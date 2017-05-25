package practice.c4.p6;

public class BSTSuccessor {
	public static void main(String args[]) {
		Node root = new Node(10);
		Node r = insert(root, 5);
		Node e = insert(root, 8);
		insert(root, 2);
		Node t = insert(root, 1);
		Node y = insert(root, 9);
		
		System.out.println("suc of" + r.i + " is " + getSuccessor(r).i);
		System.out.println("suc of" + e.i + " is " + getSuccessor(e).i);
		System.out.println("suc of" + t.i + " is " + getSuccessor(t).i);
		System.out.println("suc of" + y.i + " is " + getSuccessor(y).i);
		
	}
	
	public static Node getSuccessor(Node pre) {
		if (pre.right != null) {
			return getMin(pre.right);
		} else {
			Node parent = pre.parent;
			while (parent != null) {
				if (parent.i > pre.i){
					return parent;
				}
				parent = parent.parent;
			}
			return null;
		}
	}
	
	public static Node getMin(Node n) {
		if (n.left == null) {
			return n;
		} else {
			return getMin(n.left);
		}
	}
	
	public static Node insert(Node n, Integer i) {
		if(i<n.i){
			if( n.left == null) {
				return n.left = new Node(i, n);
			} else { 
				return insert(n.left, i);
			}
		} else {
			if (n.right == null) {
				return n.right = new Node(i, n);
			} else {
				return insert(n.right, i);
			}
		}
	}
	
	public static class Node{
		Node left, right, parent;
		Integer i;
		
		public Node(Integer i) {
			this.i = i;
		}

		public Node(Integer i, Node parent) {
			this.i = i;
			this.parent = parent;
		}
	}

}
