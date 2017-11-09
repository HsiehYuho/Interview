package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _272 {
	public static void main(String[] args) {
		_272 a = new _272();
		a.exe();
	}
	public void exe() {
		return;
	}
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
    		List<Integer> res = new ArrayList<>();
    		Stack<Integer> sStack = new Stack<>();
    		Stack<Integer> lStack = new Stack<>();
    		inorder(root,target,sStack,false); // false means smaller than target;
    		inorder(root,target,lStack,true); // true means bigger than target;
    		while(k-- > 0) {
    			if(sStack.isEmpty())
    				res.add(lStack.pop());
    			else if (lStack.isEmpty())
    				res.add(sStack.pop());
    			else if((lStack.peek() - target) < (target - sStack.peek()))
    				res.add(lStack.pop());
    			else
    				res.add(sStack.pop());
    		}
    		return res;
    }
    private void inorder(TreeNode root, double target, Stack<Integer> stack, boolean bigger) {
		if(root == null)
			return;
		// push the integer into the stack "ORDERLY", fill up sStack lowest first
		inorder(bigger ? root.right : root.left,target,stack,bigger);   
        if((!bigger&& root.val > target) || (bigger && root.val <= target))
            return;
		stack.push(root.val);
		inorder(bigger ? root.left : root.right,target,stack,bigger);			
    }
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }	
}
