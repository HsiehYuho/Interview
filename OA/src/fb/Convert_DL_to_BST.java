package fb;


public class Convert_DL_to_BST {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert_DL_to_BST sol = new Convert_DL_to_BST();
		sol.exe();
	}
	private void exe() {
		return;
	}
	private Node converting(Node start) {
		if(start == null)
			return null;
		return convert(start,null);
	}
	private Node convert(Node start, Node end) {
		if(start == end)
			return null;
		Node fast = start, slow = start;
		while(fast != end && fast.right != end) {
			fast = fast.right.right;
			slow = slow.right;
		}
		Node root = new Node(slow.val);
		root.left = convert(start,slow);
		root.right =convert(slow.right,end);
		return root;
	}
	private class Node {
		Node left, right;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}
}
