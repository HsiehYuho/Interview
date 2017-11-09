package fb;

public class Kth_Large_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
    public int kthSmallest(TreeNode root, int k) {
        int leftSum = sum(root.left);
        if(leftSum >= k)
        		return kthSmallest(root.left,k);
        else if (leftSum+1 < k)
        		return kthSmallest(root.right,k-leftSum-1);
        else
        		return root.val;
        
    }
    private int sum(TreeNode root) {
    		if(root == null)
    			return 0;
    		return 1 + sum(root.left) + sum(root.right);
    }
    public class TreeNode {
    		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
    }
}
