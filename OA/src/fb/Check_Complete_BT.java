package fb;

public class Check_Complete_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Check_Complete_BT sol = new Check_Complete_BT();
		sol.exe();
	}
	private void exe() {
		Node n0 = new Node(0), n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4);
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		System.out.println(completeBT(n0));
		return;
	}
	private boolean completeBT(Node root) {
		if(root == null) {
			return true;			
		}
		int max = countNode(root);
		return isValid(root,0,max);
	}
	private int countNode(Node node) {
		if(node == null)
			return 0;
		return 1 + countNode(node.left) + countNode(node.right);
	}
	private boolean isValid(Node node, int idx, int max) {
		if(node == null)
			return true;
		if(idx >= max) // it is greater and equal!! idx is from 0 node is from 1
			return false;
		return isValid(node.left,idx*2+1,max) && isValid(node.right,idx*2+2,max);
		
	}
	private class Node{
		Node left;
		Node right;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}

}
