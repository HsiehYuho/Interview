package fb;

public class _117 {
	public static void main(String[] args) {
		return;
	}
    public void connect(TreeLinkNode root) {
    	// important point is using three pointer, cur, nextHead, nextPtr
    	//
        TreeLinkNode curPtr = root, nextLevelHead = null, nextLevelPtr = null;
        while(curPtr != null) {
        		while(curPtr != null) { // moving right
            		// left node
            		if(curPtr.left != null) {
            			if(nextLevelHead == null)
            				nextLevelHead = curPtr.left;
            			else 
                			nextLevelPtr.next = curPtr.left;
            			nextLevelPtr = curPtr.left;
            		}

            		if(curPtr.right != null) {
            			if(nextLevelHead == null)
            				nextLevelHead = curPtr.right;
            			else
            				nextLevelPtr.next = curPtr.right;
            			nextLevelPtr = curPtr.right;
            		}
            		curPtr = curPtr.next;
        		}
        		curPtr = nextLevelHead;
        		nextLevelHead = null;
        		nextLevelPtr = null;
        }
    }
    public class TreeLinkNode {
    		int val;
    		TreeLinkNode left, right, next;
    		TreeLinkNode(int x) { val = x; }
    }
}
