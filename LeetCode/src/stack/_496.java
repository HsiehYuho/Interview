package stack;

import java.util.HashMap;
import java.util.Stack;

public class _496 {
	public static void main(String[] args) {
		_496 a = new _496();
		a.exe();
	}
	public void exe() {
		int[] nums1 = new int[] {4,1,2}; 
		int[] nums2 = new int[] {1,3,4,2};
		int[] res = nextGreaterElement(nums1,nums2);
		for(int i : res)
			System.out.print(i+" ");
		return;
	}
	public int[] nextGreaterElement(int[] nums1, int[] nums2) { // nums1: subset, nums2: set
		HashMap<Integer,Integer> map = new HashMap<>(); // record the val and the nextGreat val
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[nums1.length];
		for(int i : nums2) {
			while(!stack.isEmpty() && stack.peek() < i)
				map.put(stack.pop(),i);
			stack.push(i);
		}
		for(int i = 0; i < nums1.length; i++)
			res[i] = map.getOrDefault(nums1[i], -1);
		return res;
    }	
}
