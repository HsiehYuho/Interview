package tree;

import java.util.Stack;

public class _255 {
	public static void main(String[] args) {
		_255 a = new _255();
		a.exe();
	}
	public void exe() {
		return;
	}
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0)
            return true;
    		Stack<Integer> stack = new Stack<>();
    		int bottomLine = Integer.MIN_VALUE;
    		for(int p : preorder) {
    			if(stack.isEmpty() || stack.peek() > p) {
    				if(p < bottomLine)
    					return false;
    				stack.add(p);
    			}
    			while(!stack.isEmpty() && p > stack.peek())
    				bottomLine = stack.pop();
    			
    			stack.push(p);
    		}
    		return true;
    		
    }
}
