package binary_search;

import java.util.Arrays;

public class _259 {
	public static void main(String[] args) {
		_259 a= new _259();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1, 2, 3, 1};
		int goal = 5;
		System.out.println(threeSumSmaller(nums,goal));
		return;
	}
    public int threeSumSmaller(int[] nums, int target) {
    		Arrays.sort(nums);
    		int count = 0;
    		int n = nums.length;
    		for(int i = 0; i < nums.length; i++) {
    			int left = i+1, right = n-1;
    			while(left < right) {
    				if((nums[i] + nums[left] + nums[right]) < target) {
    					count += (right-left);
    					left++;
    				}
    				else
    					right--;
    			}
    		}
    		return count;
    }
    /*
    private int binarySearch(int[] nums, int start, int end, int goal) {
    		int left = start, right = end;
    		while(left <= end) {
    			int mid = (left + right)/2;
    			if(nums[mid] == goal)
    				return  mid; 
    			if(nums[mid] > goal && nums[mid-1] < goal)
    				return mid;
    			else if(nums[mid] < goal)
    				left = mid + 1;
    			else
    				right = mid -1;
    		}
    		return left;
    }*/
}
