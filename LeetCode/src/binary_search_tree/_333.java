package binary_search_tree;

public class _333 {
	public static void main(String[] args) {
		_333 a = new _333();
		a.exe();
	}
	public void exe() {
		return;
	}
    public int largestBSTSubtree(TreeNode root) {
    		int[] count = new int[] {0};
    		traverse(root,count);
    		return count[0];
    }
    private Node traverse(TreeNode root, int[] count) {
    		if(root == null) {
    			Node node = new Node(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
    			return node;
    		}
    		Node leftNode = traverse(root.left,count);
    		Node rightNode = traverse(root.right,count);
    		if(leftNode.size == -1 || rightNode.size == -1 || root.val <= leftNode.max || root.val >= rightNode.min )
    			return new Node(-1,0,0);
    		int size = leftNode.size + rightNode.size +1;
    		count[0] = Math.max(count[0], size);
    		return new Node(size,Math.min(root.val, leftNode.min),Math.max(root.val,rightNode.max));
    			
    }
    private class Node{
    		int size;
    		int min;
    		int max;
    		public Node(int size, int min, int max) {
    			this.min = min;
    			this.max = max;
    			this.size = size;
    		}
    }
    public class TreeNode {
    		int val;
    		TreeNode left;
    		TreeNode right;
    		TreeNode(int x) { val = x; }
    }
}
