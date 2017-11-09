package tree;

public class _298 {
	public static void main(String[] args) {
		_298 a = new _298();
		a.exe();
	}
	public void exe() {
		return;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int max = 1;
    public int longestConsecutive(TreeNode root) {
    		if(root == null)
    			return 0;
    		findLong(root,root.val,0);
    		return max;
    }
    private void findLong(TreeNode root, int target, int cur) {
    		if(root == null)
    			return;
    		if(root.val == target) {
    			cur++;
    			max = Math.max(cur, max);
    		}
    		else
    			cur = 1;
    		findLong(root.left,root.val+1,cur);
    		findLong(root.right,root.val+1,cur);

    }
}
