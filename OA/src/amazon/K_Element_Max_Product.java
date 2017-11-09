package amazon;

import java.util.Arrays;

public class K_Element_Max_Product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_Element_Max_Product sol = new K_Element_Max_Product();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {-4,-4};
		System.out.println(findMax(nums,3));
		return;
	}
	private int findMax(int[] nums, int k) {
		if(k == 0 || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int idx = findZero(nums);
		int[] neg = new int[idx];
		int[] pos = new int[nums.length - idx];
		for(int i = 0;  i < idx; i++)
			neg[i] = nums[i];
		for(int i = idx, j = 0; i < nums.length; i++, j++)
			pos[j] = nums[i];
		int max = 1;
		int posPtr = pos.length-1;
		int negPtr = 0;
		while(k > 1) {
			int posCand = 0;
			int negCand = 0;
			if(posPtr - 1 >= 0)
				posCand = pos[posPtr] * pos[posPtr-1];
			if(negPtr + 1 < neg.length)
				negCand = neg[negPtr] * neg[negPtr+1];
			if(posCand > negCand) {
				max *= posCand;
				posPtr -= 2;
			}
			else if(negCand != 0) {
				max *= negCand;
				negPtr += 2;
			}
			k = k -2;
		}
		if( k != 0 && posPtr >= 0)
			max *= pos[posPtr];
		return max;
	}
	private int findZero(int[] nums) {
		int left = 0, right = nums.length-1;
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == 0)
				return mid;
			if(nums[mid] > 0)
				right = mid;
			else 
				left = mid;
		}
		if(nums[right] < 0)
			return right+1;
		if(nums[left] < 0 && nums[right] > 0)
			return right;
		else 
			return left;
			
	}

}
