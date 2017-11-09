package sample_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
	public static void main(String[] args) {
		_15 a = new _15();
		a.exe();
	}
	public void exe() {
		return;
	}
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		int targetIdx = 0;
		while(targetIdx < nums.length-1) {
			int left = targetIdx+1, right = nums.length-1;
    		int target = -nums[targetIdx];
    		while(left < right) {
    			int cur = nums[left] + nums[right];
    			if(cur == target){
    				list.add(Arrays.asList(nums[targetIdx],nums[left],nums[right]));
                    left++;
                    right--;
                while(left > 0 && left < nums.length-1 && nums[left] == nums[left-1])
        				left++;        	
        		while(right < nums.length-1 && right > 0 && nums[right] == nums[right+1])
        				right--;        				
    			}
    			else if (cur < target) {
    				left++;
                    while(left > 0 && left < nums.length-1 && nums[left] == nums[left-1])
        				left++;        				
    			}
    			else {
        			right--;
        		while(right < nums.length-1 && right > 0 && nums[right] == nums[right+1])
        				right--;        				
    			}
    		}
    		targetIdx++;
    		while(targetIdx < nums.length && nums[targetIdx] == nums[targetIdx-1])
    			targetIdx++;
		}
		return list;
    }
}
