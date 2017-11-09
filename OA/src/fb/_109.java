package fb;

public class _109 {
	public static void main(String[] args) {
		return;
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// using fast and slow ptr to quickly reach middle	
	// create a fake tail = null to avoid to much .next determination
	// such as while(fastPtr.next != null && fastPtr.next.next != null)
	public TreeNode sortedListToBST(ListNode head) {
		return build(head,null);
	}
	private TreeNode build(ListNode head, ListNode tail) {
		// different from 108, head == tail means it is over, 
		//in other iteration, tail = slow, which is used
		if(head == tail) 
			return null;
		ListNode fast = head, slow = head;
		while(fast != tail && fast.next != tail) { // really important part
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode thread = new TreeNode(slow.val);
		thread.left = build(head,slow); 
		thread.right = build(slow.next,tail);
		return thread;
	}
	
}
