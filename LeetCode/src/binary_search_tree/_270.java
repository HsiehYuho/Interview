package binary_search_tree;

public class _270 {
	public static void main(String[] args) {
		_270 a = new _270();
		a.exe();
	}
	public void exe() {
		return;
	}
	public int closestValue(TreeNode root, double target) {
		TreeNode roof = null, ceil = null;
		TreeNode cur = root;
		while(cur != null) {
			if(target == cur.val)
				return cur.val;
			else if(target > cur.val) {
				roof = cur;
				cur = cur.right;
			}
			else {
				ceil = cur;
				cur = cur.left;
			}
		}
		if(roof == null)
			return ceil.val;
		if (ceil == null)
			return roof.val;
		return (target - roof.val) > (ceil.val - target) ? ceil.val : roof.val;
	}
    	public class TreeNode {
    		int val;
    		TreeNode left;
    		TreeNode right;
    		TreeNode(int x) { val = x; }
    }
}
