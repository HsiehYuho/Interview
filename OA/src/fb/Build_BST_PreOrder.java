package fb;

public class Build_BST_PreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Build_BST_PreOrder sol = new Build_BST_PreOrder();
		sol.exe();
	}
	private void exe() {
		buildTree(new int[] {0});
		return;
	}
	private TreeNode buildTree(int[] nums) {
		TreeNode root = new TreeNode(nums[0]);
		for(int i = 1; i < nums.length; i++) {
			build(nums[i],root);
		}
		return root;
	}
	private TreeNode build(int val, TreeNode node) {
		if(val > node.val) {
			if(node.right == null)
				node.right = new TreeNode(val);
			else
				node.right = build(val,node.right);
		}
		else {
			if(node.left == null)
				node.left = new TreeNode(val);
			else 
				node.left = build(val,node.left);
		}
		return node;
	}
	private class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}


}
