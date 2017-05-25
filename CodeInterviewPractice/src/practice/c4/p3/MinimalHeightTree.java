package practice.c4.p3;

public class MinimalHeightTree {
	public static void main(String args[]) {
		final int SIZE = 10;
		int[] input = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			input[i] = i;
		}

		Node tree = createBST(input);
		tree.inOrderPrint();
		System.out.println("Height: " + getHeight(tree));
	}
	
	public static Node createBST(int[] array) {
		return createBST(array, 0, array.length -1);
	}
	
	public static int getHeight(Node node) {
		if(node == null) {
			return 0;
		}
		int left = getHeight(node.left);
		int right = getHeight(node.right);
		return Math.max(left , right) +1;
	}
	
	public static Node createBST(int[] array, int low, int hi) {
		if (hi < low) {
			return null;
		}
		int mid = (low + hi) /2;
		Node n = new Node();
		n.data = array[mid];
		n.left = createBST(array, low,  mid -1);
		n.right = createBST(array, mid+1, hi);
		return n;
	}
	
	private static class Node {
		Node left, right;
		Integer data;

		public void inOrderPrint() {
			if (left != null) {
				left.inOrderPrint();
			}
			System.out.print(data + ",");
			if (right != null) {
				right.inOrderPrint();
			}
		}
	}

}
