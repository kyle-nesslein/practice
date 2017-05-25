package practice.c4.p4;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeToLinkedList {
	public static void main(String args[]) {
		Node root = new Node(10);
		insert(root, 5);
		insert(root, 3);
		insert(root, 8);
		insert(root, 2);
		insert(root, 14);
		
		
		printll(toLinkedLists(root));
	}
	
	public static ArrayList<LinkedList<Node>> toLinkedLists(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		current.add(root);
		result.add(current);
		
		while (current != null && !current.isEmpty()) {
			LinkedList<Node> next = new LinkedList<Node>();
			for(Node n : current) {
				if (n.left != null) {
					next.add(n.left);
				}
				if (n.right != null) {
					next.add(n.right);
				}
			}
			result.add(next);
			current = next;
		}
		
		return result;
	}
	
	public static void printll(ArrayList<LinkedList<Node>> input) {
		for (LinkedList<Node> l : input) {
			System.out.print("List");
			for (Node n : l) {
				System.out.print(n.data + ",");
			}
			System.out.println();
		}
		
	}
	public static class Node {
		Node left, right;
		Integer data;
		Integer depth;
		
		public Node(Integer i) {
			data = i;
		}
	}
	
	public static void insert(Node n, Integer i) {
		if (i < n.data){
			if (n.left == null) {
				n.left = new Node(i);
			} else {
				insert(n.left, i);
			}
		} else {
			if (n.right == null) {
				n.right = new Node(i);
			} else {
				insert(n.right, i);
			}
		}
	}
}
