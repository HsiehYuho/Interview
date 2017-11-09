package fb;

import java.util.Stack;

public class BST_to_Circular_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_to_Circular_LinkedList sol = new BST_to_Circular_LinkedList();
		sol.exe();
	}
	private void exe() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n7 = new Node(7);
		Node n6 = new Node(6);
		n5.left = n3;
		n3.left = n1;
		n3.right = n4;
		n5.right = n7;
		n7.left = n6;
		n1.right = n2;
		Node head = findHead(n5);
		while(head != null) {
			System.out.print(head.val);
			head = head.right;
		}
		return;
	}
	// Constant Space
	private Node convert(Node node) {
		// base case
		if(node == null)
			return null;
		// if left subtree exists, find the rightmost child and connect the node with rightmost child
		if(node.left != null) {
			Node left = convert(node.left);
			while(left.right != null) {
				left = left.right;
			}
			left.right = node;
			node.left = left;
		}
		if(node.right != null) {
			Node right = convert(node.right);
			while(right.left != null)
				right = right.left;
			right.left = node;
			node.right =right;
		}
		return node;
	}
	private Node findHead(Node head) {
		Node LDHead = convert(head);
		while(LDHead.left != null)
			LDHead = LDHead.left;
		return LDHead;
	}
	private class Node {
		Node left, right;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}

}
