package fb;

public class Search_In_Rotate_Array {
	public static void main(String[] args) {
		return;
	}
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		int left = 0, right = nums.length-1;
		while(left + 1 < right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == target)
				return mid;
			if(nums[left] < nums[mid]) {
				if(nums[left] <= target)
					right = mid;
				else
					left = mid;
			}
			else {
				if(nums[mid] <= target)
					left = mid;
				else
					right = mid;
			}
		}
		if(nums[left] == target)
			return left;
		if(nums[right] == target)
			return right;
		return -1;
	}
}
