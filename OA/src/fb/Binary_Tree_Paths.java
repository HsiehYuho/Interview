package fb;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if(root == null) {
			System.out.println("");
			res.add("");
			return res;
		}
		print(root,res,"");
		return res;
	}
	private void print(TreeNode node, List<String> res, String ans) {
		ans = ans.length() == 0 ? node.val + "" : ans + "->" + node.val; // first node
		if(node.left == null && node.right == null) {
			System.out.println(ans);
			res.add(new String(ans));
		}
		if(node.left != null)
			print(node.left,res,ans);
		if(node.right != null)
			print(node.right,res,ans);
		return;
			
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
