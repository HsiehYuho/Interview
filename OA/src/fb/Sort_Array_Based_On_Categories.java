package fb;

public class Sort_Array_Based_On_Categories {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort_Array_Based_On_Categories sol = new Sort_Array_Based_On_Categories();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,5,3,2,4,1,7};
		sortByCategories(nums);
		for(int i : nums)
			System.out.print(i + " ");
		return;
	}
	private int[] sortByCategories(int[] nums) {
		int low = 0, high = nums.length-1;
		for(int i = 0; i < high; i++) {
			if(findCategories(nums[i]) == 0) {
				swap(nums,i,low);
				low++;
			}
			else if(findCategories(nums[i]) == 2) {
				swap(nums,i,high);
				high--;
				i--;
			}
		}
		return nums;
	}
	private void swap(int[] nums, int i, int j) {
		int tmp  = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		return;
	}
	private int findCategories(int n) {
		return n % 3;
	}
	
}
