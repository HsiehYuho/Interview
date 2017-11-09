package fb;

public class Builder_Tree_In_Post {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
	private TreeNode build(int[] in, int[] po, int s1, int e1, int s2, int e2) {
		if(s1 > e1 || s2 > e2)
			return null;
		TreeNode root = new TreeNode(po[e2]); // the last element
		int i = s1;
		for(; i <= e1; i++) {
			if(in[i] == po[e2])
				break;
		}
		root.left = build(in,po,s1,i,s2,s2+(i-s1));
		root.right = build(in,po,s1+1,e1,s2+(i-s1)+1,e2);
		return root;
	}
	public class TreeNode{
		int val;
		TreeNode left, right;
		public TreeNode(int v) {
			this.val = v;
			left = null;
			right = null;
		}
	}
}
