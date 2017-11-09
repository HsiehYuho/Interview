package asana;

public class _98 {
	public static void main(String[] args) {
		return;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	// i forget to consider the upperlimit and lowerlimit, 
	// such that the most left part should be lower than right part 
	// take care of max and min
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		return isValid(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}
	private boolean isValid(TreeNode node, int max, int min) {
		if(node == null)
			return true;
		if(node.left != null &&  node.left.val >= node.val)
			return false;
		if(node.right != null && node.right.val <= node.val)
			return false;
		if(node.val >= max || node.val <= min)
			return false;
		return isValid(node.left,Math.min(node.val, max),min) &&    
                isValid(node.right,max,Math.max(min,node.val));
	}
}
