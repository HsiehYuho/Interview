package fb;

import java.util.Stack;

public class Convert_BST_to_DoubleLInkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Build the tree
		Convert_BST_to_DoubleLInkedList a= new Convert_BST_to_DoubleLInkedList();
		a.exe();

	}
	public void 	exe() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n6 = new TreeNode(6);
		n5.left = n3;
		n3.left = n1;
		n3.right = n4;
		n5.right = n7;
		n7.left = n6;
		n1.right = n2;
		TreeNode head = convert(n5);
		while(head != null) {
			System.out.print(head.val);
			head = head.right;
		}		
		return;
	}
	public TreeNode convert(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if(root == null) return null;
		TreeNode dummy = new TreeNode(-1);
		TreeNode pre = dummy;
		TreeNode ptr = root;
		while(ptr != null) {
			stack.add(ptr);
			ptr = ptr.left;
		}
		while(stack.size()!=0) {
			ptr = stack.pop();
			ptr.left = pre;
			pre.right = ptr;
			pre = ptr;
			ptr = ptr.right;
			while(ptr != null) {
				stack.add(ptr);
				ptr = ptr.left;
			}
		}
		return dummy.right;
		/*
		 * if going to link head and tail
		 * using 
		 * dummy.right.left = pre;
		 * pre.right = dummy.right;
		 * 
		 * 
		 * 
		 */
		// arrive leftmot point
		
	}
	
	public class TreeNode {
	     public int val;
		      public TreeNode left, right;
		      public TreeNode(int val) {
		          this.val = val;
		          this.left = this.right = null;
		      }
	}
}