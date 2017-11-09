package tree;

//import java.util.HashMap;

public class _250 {
	public static void main(String[] args) {
		_250 a = new _250();
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
    public int countUnivalSubtrees(TreeNode root) {
//    		HashMap<TreeNode,Boolean> map = new HashMap<>();
    		int[] count = new int[] {0};
    		if(root == null)
        		return count[0];    			
    		compute(root,count);
    		return count[0];
    }
    private boolean compute(TreeNode node,int[] count) {
    		if(node.left == null && node.right == null) {
    			count[0]++;
    			return true;
    		}
    		boolean left = node.left == null ? true : compute(node.left,count);
    		boolean right = node.right == null ? true : compute(node.right,count);
    		if(node.left != null && node.left.val != node.val)
    			return false;
    		if(node.right != null && node.right.val != node.val)
    			return false;
    		if(left && right) 
    			count[0]++;
		return true;

    }
}
