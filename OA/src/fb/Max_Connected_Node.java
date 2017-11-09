package fb;

public class Max_Connected_Node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		Max_Connected_Node sol = new Max_Connected_Node();
		sol.exe();
	}
	private void exe() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(11);
		TreeNode n7 = new TreeNode(15);
		n1.left = n2;
		n1.right = n7;
		n2.left = n3;
		n3.left = n5;
		n2.right = n4;
		n4.right = n6;
		System.out.println(getMaxSum(n1));
		return;
	}
	private int max = 0;
	private int getMaxSum(TreeNode root) {
		getSum(root);
		return max;
	}
	private int getSum(TreeNode node) {
		if(node == null)
			return 0;
		int left = getSum(node.left);
		int right = getSum(node.right);
		max = Math.max(max, node.val + left + right);
		return Math.max(right,left)+node.val;
	}
	private class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
