package fb;

import java.util.Stack;

public class Tree_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	
	// using stack to store the node
	// work on going left and left and left 
	// once pop out the node, to check whether it has right node then go left 
	Stack<TreeNode> stack;
	public void BSTIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null) {
			stack.add(cur);
			cur = cur.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node; 
        if(cur.right != null) {
        		cur = cur.right;
        		stack.add(cur);
        		while(cur.left != null) {
        			cur = cur.left;
        			stack.add(cur);
        		}
        }
        return node.val;
    }
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	 }

}
