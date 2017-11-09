package tree;

public class _156 {
	public static void main(String[] args) {
		_156 a= new _156();
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
	 // rotatng the tree upside down
	 public TreeNode upsideDownBinaryTree(TreeNode root) {
		 if(root == null)
			 return null;
		 if(root.left == null) {
			 return root;
		 }
		 TreeNode l = root.left;
		 TreeNode r = root.right;
		 TreeNode res = upsideDownBinaryTree(l);
		 root.left = null;
		 root.right = null;
		 l.right = root; // not res.right = root 
		 l.left = r; // not res.left = r because we need to move the whole left subtree to the top
		 return res;
	 }
}
