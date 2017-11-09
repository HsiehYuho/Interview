package silding_window;

import java.util.PriorityQueue;

public class _239 {
	public static void main(String[] args) {
		_239 a = new _239();
		a.exe();
	}
	public void exe() {
		for(int i : maxSlidingWindow(new int[] {},0))
			System.out.print(i + " ");
		return;
	}
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[]{};
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int leftPtr = 0, rightPtr = 0;
        int ansIndex = 0;
        while(rightPtr < nums.length) {
        		while(pq.size() < k) {
        			pq.add(nums[rightPtr]);
        			rightPtr++;
        		}
        		ans[ansIndex++] = pq.peek();
        		// moving window
        		pq.remove(nums[leftPtr]);
        		leftPtr++;
        }
        	return ans;
    }
}
