package fb;


public class Number_Of_Subset_Smaller_K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number_Of_Subset_Smaller_K sol = new Number_Of_Subset_Smaller_K();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,2, 3, 4,5,6};
		int target = 4;
		System.out.println(numberOfSub(nums,target));
		return;
	}
	private int numberOfSub(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		while(right > left && nums[right]+nums[left]>= target)
			right --;
		int count = 0;
		while(right > left) {
			if(nums[right] + nums[left] < target) {
				count += (Math.pow(2,right-left)-1);
			}
			left++;
			while(right > left && nums[right]+nums[left] >= target) {
				right--;
			}			
		}
		for(int num : nums) {
			if(num * 2 < target)
				count++;
			else 
				break;
		}
		return count;	
	}

	
	
	
//	private int numberOfSub(int[] nums,int target) {
//		int cur = Integer.MAX_VALUE; // [min,max]
//		int[] count = new int[] {0};
//		dfs(nums,0,target,cur,count);
//		return count[0];
//		
//	}
//	private void dfs(int[] nums, int pos, int target, int cur, int[] count) {
//		if(pos == nums.length || nums[pos] >= target)
//			return;
//		for(int i = pos; i < nums.length; i++) {
//			if(cur == Integer.MAX_VALUE) {
//				cur = nums[i];
//				if(cur*2  < target) {
//					count[0]++;
//					dfs(nums,i+1,target,cur,count);
//					cur 	= Integer.MAX_VALUE;
//				}
//				else
//					break;
//			}
//			else if (cur + nums[i] < target) {
//				count[0]++;
//				dfs(nums,i+1,target,cur,count);
//			}
//			else 
//				break;
//		}
//	}

}
