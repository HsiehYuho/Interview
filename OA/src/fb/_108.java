package fb;

public class _108 {
	public static void main(String[] args) {
		return;
	}
    public TreeNode sortedArrayToBST(int[] nums) {
    	// using the recursive function to build 
    		return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums, int left, int right) {
    		if(right >= nums.length || left < 0 || left > right)
    			return null;
    		int mid = (left+right) /2;
    		TreeNode curNode = new TreeNode(nums[mid]);
    		curNode.left = build(nums,left,mid-1);
    		curNode.right = build(nums,mid+1,right);
    		return curNode;
    		
    }
    public class TreeNode {
    		int val;
    		TreeNode left;
    		TreeNode right;
    		TreeNode(int x) { val = x; }
    }
}
