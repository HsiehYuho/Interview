package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_Sum_Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_Sum_Recursive sol = new K_Sum_Recursive();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,2,3,4,5,6,7,8};
		List<List<Integer>> res = findKSum(nums,3,10);
		for(List<Integer> list : res) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		return;
	}
	private List<List<Integer>> findKSum(int[] nums, int k, int target) {
		if(k < 1)
			return new ArrayList<>(); 
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>(); 
		dfs(res,nums,k,target,0,new ArrayList<Integer>());
		return res;
	}
	private void dfs(List<List<Integer>> res, int[] nums, int k, int target, int pos, List<Integer> record) {
		if(k == 2) {
			int left = pos, right = nums.length-1;
			while(left < right) {
				if(nums[left]+nums[right] == target) {
					record.add(nums[left]);
					record.add(nums[right]);
					res.add(new ArrayList<>(record));
					record.remove(record.size()-1);
					record.remove(record.size()-1);
					
					left++;
					right--;
					while(left < nums.length && nums[left] == nums[left-1])
						left++;
					while(right >= pos && nums[right] == nums[right+1])
						right--;
				}
				else if(nums[left] +nums[right] < target)
					left++;
				else 
					right--;
			}
		}
		else {
			for(int i = pos; i < nums.length; i++) {
				record.add(nums[i]);
				dfs(res,nums,k-1,target-nums[i],i+1,record);
				record.remove(record.size()-1);
			}
		}
	}
	

}
