package sample_questions;

import java.util.Arrays;

public class Nums_Maxes {

	public static void main(String[] args) {
		Nums_Maxes a = new Nums_Maxes();
		a.exe();
		
	}
	public  void exe() {
		int[] nums = new int[] {1,2,3,5};
		int[] maxes = new int[] {4};
		int[] res = findSubMax(nums,maxes);
		for(int i : res)
			System.out.print(i + " ");
		return;
	}
	public int[] findSubMax(int[] nums, int[] maxes) {
		Arrays.sort(nums);
		int[] res = new int[maxes.length];
		for(int i = 0; i < maxes.length; i++) {
			res[i] = binarySearch(nums,maxes[i])+1;
		}
		return res;
	}
	public int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		while(left + 1 < right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == target)
				return mid;
			if(nums[mid] > target)
				right = mid;
			else 
				left = mid;
		}
		if(nums[left] == target)
			return left;
		if(nums[right] == target)
			return right;
		if(target > nums[right])
			return right; // no need to add one because the situation is the same as targe == nums[right]
		if(target > nums[left])
			return left;
		else
			return left-1;
	}


}
