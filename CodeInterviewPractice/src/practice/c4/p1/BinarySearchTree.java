package practice.c4.p1;

public class BinarySearchTree{
	public static void main(String args[]) {

		BSTNode root = new BSTNode(5);
		root.insert(2);
		root.insert(8);
		root.insert(4);
		root.insert(1);
		root.insert(7);
		root.insert(9);
		root.inOrderTraverse();
		System.out.println(root.isBalanced());
		
	}
	
	public static class BSTNode {
		BSTNode left, right;
		Integer data;
		
		public BSTNode(Integer value) {
			data = value;
		}
		
		public void insert(Integer value) {
			if (value < data) {
				if (left == null) {
					left = new BSTNode(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BSTNode(value);
				} else {
					right.insert(value);
				}
			}
		}
		
		public boolean isBalanced() {
			if (checkHeight() == -1) {
				return false;
			} else {
				return true;
			}
		}
		
		public Integer checkHeight() {
			Integer leftHeight = 0, rightHeight = 0;
			if (left != null) {
				leftHeight = left.checkHeight();
			}
			if (right != null) {
				rightHeight = right.checkHeight();
			}
			if (leftHeight == -1 || rightHeight == -1) {
				return -1;
			} else if (Math.abs(leftHeight - rightHeight) > 1) {
				return -1;
			} else {
				return Math.max(leftHeight, rightHeight) + 1;
			}
		}
		
		public void inOrderTraverse() {
			if (left != null) {
				left.inOrderTraverse();
			}
			System.out.print(data + ",");
			if (right != null) {
				right.inOrderTraverse();
			}
		}

		public void preOrderTraverse() {
			System.out.println(data + ",");
			if (left != null) {
				left.preOrderTraverse();
			}
			if (right != null) {
				right.preOrderTraverse();
			}
		}

		public void postOrderTraverse() {
			if (left != null) {
				left.postOrderTraverse();
			}
			if (right != null) {
				right.postOrderTraverse();
			}
			System.out.println(data + ",");
		}
	}
}
