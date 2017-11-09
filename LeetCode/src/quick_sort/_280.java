package quick_sort;

public class _280 {
	public static void main(String[] args) {
		_280 a = new _280();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1,2,3,3,3,3,4,5,6,7};
		wiggleSort(nums);
		for(int i : nums) {
			System.out.print(i+" ");
		}
		return;
	}
    public void wiggleSort(int[] nums) {
    		int n = nums.length;
    		for(int i = 1; i < n; i++) {
    			if((i&1) == 1 ) {
    				if(nums[i] < nums[i-1])
    				swap(nums,i,i-1);
    			}
    			else if(i != 0 && nums[i] > nums[i-1])
    				swap(nums,i,i-1);
    		}
    		return;
        
    }
	/*
    private int pickMedian(int[] nums, int start, int end, int k) {
    		int pivot = nums[end];
    		int left = start, right = end;
    		while(true) {
    			while(left < right && nums[left] < pivot)
    				left++;
    			while(right > left && nums[right] >= pivot)
    				right--;
    			if(left == right)
    				break;
    			swap(nums,left,right);
    		}
    		swap(nums,left,end);
    		if(k == left+1)
    			return pivot;
    		else if(k > left+1)
    			return pickMedian(nums,left+1,end,k);
    		else
    			return pickMedian(nums,start,left-1,k); // left is by no means be answer
    }*/
    private void swap(int[] nums, int left, int right) {
    		int tmp = nums[left];
    		nums[left] = nums[right];
    		nums[right] = tmp;
    		return;
    }
}
