package sample_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18 {
	public static void maind(String[] args) {
		_18 a = new _18();
		a.exe();
	}
	public void exe() {
		return;
	}
	// we can find the boundary at first, then filter out every impossible numbers 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
        		return res;
        int len = nums.length;
        	Arrays.sort(nums);
        	int max = nums[len-1];
        	if(max * 4  < target || nums[0] * 4 > target)
        		return res;
        	int i, z;
        	for(i = 0; i < len; i++) {
        		z = nums[i];
        		if( i > 0 && z == nums[i-1]) // avoid duplicate
        			continue;
        		if((z + 3 * max) < target)
        			continue;
        		else if( z * 4 > target)
        			break;
        		else if (z * 4 == target) {
        			if(i+3 < len && nums[i+3] == z)
        				res.add(Arrays.asList(z,z,z,z));
        			break;
        		}
        		threeSumForFourSum(nums,target-z,i+1,len-1,res,z);
        	}
        	return res;
    }
    private void threeSumForFourSum(int[] nums, int target, int lo, int hi, List<List<Integer>> res, int z1) {
    		if(lo+1 >= hi)
    			return;
    		int max = nums[hi];
    		if(nums[lo] * 3 > target || nums[hi] * 3 < target) // the range number is too large or too small
    			return;
    		int i, z;
    		for(i = lo; i <= hi; i++) {  // different part
    			z = nums[i];
    			if(i > lo && z == nums[i-1]) // important
    				continue;
    			if(z + max*2 < target)
    				continue;
    			else if (3 * z > target)
    				break;
    			else if (3 * z == target) {
    				if(i+2 <= hi && nums[i+2] == z)
    					res.add(Arrays.asList(z,z,z,z1));
    				break;
    			}
    			twoSumForFourSum(nums,target-z,i+1,hi,res,z1,z);
    			
    		}
    		return;
    }
    private void twoSumForFourSum(int[] nums, int target, int lo, int hi, List<List<Integer>> res, int z1, int z2) {
    		if(lo >= hi)
    			return;
    		if(2 * nums[lo] > target || 2 * nums[hi] < target)
    			return;
    		int i = lo, j = hi, sum, pre;
    		while(i < j) {
    			sum = nums[i] + nums[j];
    			if(sum == target) {
    				res.add(Arrays.asList(nums[i],nums[j],z1,z2));
    				pre = nums[i];
    				while(++i < j && pre == nums[i]);
    				pre = nums[j];
    				while(i < --j && pre == nums[j]);
    			}
    			if(sum > target)
    				j--;
    			if(sum < target) // not else!! but why ?? 
    				i++;
    		}
    		return;
    }
}
