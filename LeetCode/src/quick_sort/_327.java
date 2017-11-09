package quick_sort;

public class _327 {
	public static void main(String[] args) {
		_327 a= new _327();
		a.exe();
	}
	public void exe() {
		System.out.println(countRangeSum(new int[] {1,-3,-2,5,-1},-3,3));
		return;
	}
    public int countRangeSum(int[] nums, int lower, int upper) {
    		int n = nums.length;
    		long[] newNums = new long[n+1]; // maybe here should be long
    		for(int i = 0; i < n; i++) {
    			newNums[i+1] = newNums[i] + nums[i];
    		}
    		return count(newNums,0,n+1,upper,lower);
    }
    private int count(long[] nums, int start, int end, int hi, int lo) {
    		if((end - start) <= 1)
    			return 0;
    		int mid = (start + end) / 2;
    		int count = count(nums,start,mid,hi,lo) + count(nums,mid,end,hi,lo);
    		int j = mid, k = mid, l = mid,index = 0;
    		long[] cache = new long[end-start];
    		for(int i = start; i < mid; i++) { // find an element in left and the valid range in the right
    			while(j < end && nums[j] - nums[i] < lo) j++;
    			while(k < end && nums[k] - nums[i] <= hi) k++;
    				count += (k - j);
    			// do the merge part
    			while(l < end && nums[l] < nums[i])  cache[index++] = nums[l++]; 
    			cache[index++] = nums[i];
    		}
    		// only copy the "moving" part, the rest of "OK" part is remain the same
    		System.arraycopy(cache, 0, nums, start, l-start);
    	    return count;
    }
}
