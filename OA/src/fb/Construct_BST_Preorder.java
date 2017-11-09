package fb;

public class Construct_BST_Preorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Construct_BST_Preorder sol = new Construct_BST_Preorder();
		sol.exe();
	}
	private void exe() {
		TreeNode root = constructBST(new int[] {0,0});
		root.left =null;
		root.right = null;
	}
	int idx = 0;
	private TreeNode constructBST(int[] nums){
		return construct(nums,Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	private TreeNode construct(int[] nums, int max, int min) {
		if(nums[idx] >= nums.length)
			return null;
		if(nums[idx] >= max || nums[idx] <= min)
			return null;
		TreeNode root = new TreeNode(nums[idx++]);
		root.left = construct(nums,root.val,min);
		root.right = construct(nums,max,root.val);
		return root;
	}
	private class TreeNode {
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

}
