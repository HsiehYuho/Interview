package tree;

import java.util.ArrayList;
import java.util.List;

public class _366 {
	public static void main(String[] args) {
		_366 a = new _366();
		a.exe();
	}
	public void exe() {
		return;
	}
		
    public List<List<Integer>> findLeaves(TreeNode root) {
    		List<List<Integer>> res = new ArrayList<>();
    		height(root,res);
    		return res;
    }
    private int height(TreeNode root, List<List<Integer>> res) {
    		if(root == null)
    			return -1;
    		int level = 1 + Math.max(height(root.left, res),height(root.right,res));
    		if(level > res.size()-1)
    			res.add(new ArrayList<Integer>());
    		res.get(level).add(root.val);
    		root.left = null;
    		root.right = null;
    		return level;
    }
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}

