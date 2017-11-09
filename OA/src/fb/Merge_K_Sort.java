package fb;

public class Merge_K_Sort {

	public static void main(String[] args) {
		Merge_K_Sort a = new Merge_K_Sort();
		a.exe();
	}
	public void exe() {
		return;
	}
	// using priorityQueue or MergeSort are both fine, make sure every list contains listNode?
    public ListNode mergeKLists(ListNode[] lists) {
    		return mergeLists(lists,0,lists.length-1);
    }
    // divide the list 
    public ListNode mergeLists(ListNode[] lists, int start, int end) {
    		if(start == end) {
    			return lists[start];
    		}
    		if(start > end) {
    			return null;
    		}
    		int mid = start + (end - start) /2;
    		ListNode leftPartHead = mergeLists(lists,start,mid);
    		ListNode rightPartHead = mergeLists(lists,mid+1,end);
    		return merge(leftPartHead,rightPartHead);
    }
    // merge the nodes head 
    public ListNode merge(ListNode node1, ListNode node2) {
    		if(node1 == null)
    			return node2;
    		if(node2 == null)
    			return node1;
    		if(node1.val < node2.val) {
    			node1.next = merge(node1.next,node2);
    			return node1;
    		}
    		else {
    			node2.next = merge(node1,node2.next);
    			return node2;
    		}	
    }

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
