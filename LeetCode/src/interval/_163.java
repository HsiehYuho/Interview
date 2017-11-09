package interval;

import java.util.ArrayList;
import java.util.List;

public class _163 {
	public static void main (String[] args) {
		_163 a = new _163();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {0,1,2,3,50,75,98};
        List<String> res = findMissingRanges(nums,-4,99);
		for(String s : res)
			System.out.println(s);
        return;
	}
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    		List<String> res = new ArrayList<>();
    		for(int n : nums) {
    			if(n == Integer.MIN_VALUE){
    				lower = n+1;
	    			continue;
	    		}
	    		int justBelow = n-1;
	    		if(lower == justBelow) {
	    			res.add(lower+"");
	    		}
	    		else if(lower < justBelow){
	    			res.add(lower+"->"+justBelow);
	    		}
	    		if( n < Integer.MAX_VALUE)
	    			lower = n+1;
	    		else
	    			return res;
	    	}
	    	// if lower is the max value, lower + 1 will be min
	    	if(lower == upper)
	    		res.add(lower+"");
	    	else if(lower < upper) {
	    		res.add(lower+"->"+upper);
	    	}
	    	return res;
    	}
/*
    private int returnPos(int[] nums, int target) {
    		int left = 0, right = nums.length-1;
    		while(left <= right) {
    			int mid = left + (right - left) / 2;
    			if(nums[mid] == target)
    				return mid;
    			else if (nums[mid] > target)
    				right = mid-1;
    			else
    				left = mid+1;
    		}
    		return left;
    }
*/
}
