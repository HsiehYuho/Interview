package fb;

public class Sorted_Array {
	public static void main(String[] args) {
		return;
	}
	public int find(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		while(start+1 < end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target)
				return start;
			if( target < nums[start]) {
				if(target < nums[mid])
					end = mid;
				else
					start = mid;
			}
			else {
				if(nums[mid] < target)
					start = mid;
				else
					end = mid;
			}
		}
		if(nums[start] == target)
			return start;
		else if(nums[end] == target)
			return end;
		else 
			return -1;
	}
}
