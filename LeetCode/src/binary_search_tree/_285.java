package binary_search_tree;

public class _285 {
	public static void main(String[] args) {
		_285 a = new _285();
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    		if(root == null)
    			return null;
    		if(root.val <= p.val) {
    			return inorderSuccessor(root.right,p);
    		}
    		// when left sub tree cannot find the successor -> return the node
    		else {
    			TreeNode left = inorderSuccessor(root.left,p);
    			return left == null ? root : left;
    		}
    }
    /*
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    		TreeNode candidate = root.right;
    		if(candidate == null && root == p)
    			return null;
    		while(candidate != null && candidate.left != null) {
    			candidate = candidate.left;
    		}
    		return find(root,candidate,p);
    }
    private TreeNode find(TreeNode node, TreeNode candidate, TreeNode target) {
    		if(node == target)
    			return candidate;
            // turn right
    		if(target.val > node.val) {
    			TreeNode nextCandidate = node.right;
    			while(nextCandidate != null && nextCandidate.left != null)
    				nextCandidate = nextCandidate.left;
    			if(nextCandidate == node.right)
    				return null;
    			return find(node.right,nextCandidate,target);
    		}
    		else { // turn left
    			TreeNode nextCandidate = node.left;
    			if(nextCandidate.right != null) {
    				nextCandidate = nextCandidate.right;
    				while(nextCandidate.left != null)
    					nextCandidate = nextCandidate.left;
    			}   
    			else {
    				nextCandidate = node;
    			}
    			return find(node.left,nextCandidate,target);
    		}
    } 
     
     */
}
