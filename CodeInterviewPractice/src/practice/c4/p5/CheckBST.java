package practice.c4.p5;

public class CheckBST {
	public static void main(String args[]) {
		Node root = new Node(10);
		insert(root, 5);
		insert(root, 8);
		insert(root, 2);
		insert(root, 1);
		insert(root, 9);

		System.out.println("Is BST: " + isBST(root));
		
		
		root = new Node(10);
		root.left = new Node(11);
		insert(root, 4);
		insert(root, 6);
		insert(root, 4);
		insert(root, 9);
		System.out.println("Is BST: " + isBST(root));
	}
	
	public static boolean isBST(Node node) {
		return isBST(node, null, null);
	}
	
	public static boolean isBST(Node node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		if ((min != null && node.data < min) || (max != null && node.data > max)) {
			return false;
		}
		if (!isBST(node.left, min, node.data)||!isBST(node.right, node.data, max)) {
			return false;
		}
		return true;
	}
	
	private static class Node {
		Node left, right;
		Integer data;
		
		public Node(Integer i) {
			data = i;
		}
	}
	
	public static void insert(Node n, Integer value) {
		if (value < n.data){
			if (n.left == null) {
				n.left = new Node(value);
			} else {
				insert(n.left, value);
			}
		} else {
			if (n.right == null) {
				n.right = new Node(value);
			} else {
				insert(n.right, value);
			}
		}
	}
}
