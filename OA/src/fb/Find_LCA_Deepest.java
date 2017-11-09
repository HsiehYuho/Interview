package fb;

public class Find_LCA_Deepest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_LCA_Deepest sol = new Find_LCA_Deepest();
		sol.exe();
	}
	public void exe() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
//		n4.right = n7;
		returnNode lca = findLCADeepest(n1);
		System.out.println(lca.node.val);		
		return;
	}
	private returnNode findLCADeepest(TreeNode root){
		if(root == null)
			return new returnNode(null,0);
		returnNode left = findLCADeepest(root.left);
		returnNode right = findLCADeepest(root.right);
		int depth = Math.max(left.depth,right.depth)+1;
		if(left.depth == right.depth)
			return new returnNode(root,depth);
		if(left.depth < right.depth)
			return new returnNode(right.node,depth); // important because if the depth is equal -> means this node could be parents 
		else
			return new returnNode(left.node,depth);  
	}
	private class returnNode{
		TreeNode node;
		int depth;
		public returnNode(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
	private class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val){
			this.val = val;
			return;
		}
	}

}
