package fb;

public class Count_Number_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count_Number_Sorted_Array sol = new Count_Number_Sorted_Array();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,2,2,2,2,2,4,4,5,5,5,5,6};
		int target = 2;
		System.out.println(findTargetNumber(nums,target));
		return;
	}
	private int findTargetNumber(int[] nums, int target) {
		int left = bsearch(nums,target);
		int right = bsearch(nums,target+1);
		return right - left;
	}
	
	private int bsearch(int[] nums, int target) { // find the first one 
		int n = nums.length;
		int left = 0, right = n-1;
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target)
				left = mid;
			else
				right = mid;
		}
		if(nums[right] < target)
			return right+1;
		if(nums[left] > target)
			return left -1;
		if(nums[left] == target)
			return left;
		else
			return right;
	}

}
