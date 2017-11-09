package fb;

public class Kth_Largest_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	// using quick select sort
	public int findKthLargest(int[] nums, int k) {
		k = nums.length - k;
		int left = 0, right = nums.length-1;
		while(left < right) {
			int ans = quickSort(nums,left,right);
			if(ans > k)
				right = ans-1;
			else if(ans < k)
				left = ans+1;
			else 
				return nums[ans];
		}
		return -1;
	}
	private int quickSort(int[] nums, int left, int right) {
		int lo = left, hi = right-1, pivot = right;
		while(lo <= hi) {
			while(lo < nums.length && nums[lo] < nums[pivot])
				lo++;
			while(hi >= 0 && nums[hi] >= nums[pivot])
				hi--;
			if(lo < hi)
				swap(nums,lo,hi);
		}
		swap(nums,lo,pivot);
		return lo;
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		return;
	}

}
