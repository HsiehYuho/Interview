package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Product_Prime_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product_Prime_Number a = new Product_Prime_Number();
		int[] nums = new int[] {2,2,5,7};
		HashSet<Integer> res = a.get_product(nums);
		List<Integer> ans = a.get_product_without_set(nums);
		for(int i : ans)
			System.out.println(i);
		for(int i : res)
			System.out.println(i);
		
	}
	private List<Integer> get_product_without_set(int[] nums){
		List<Integer> ans = new ArrayList<>();
		dfs_without_hashSet(ans,nums,0,1);
		return ans;
	}
	private HashSet<Integer> get_product(int[] nums){
		HashSet<Integer> ans = new HashSet<>();
		dfs(ans,nums,0,1);
		return ans;
	}
	private void dfs(HashSet<Integer> ans, int[] nums, int pos, int cur) {
		ans.add(cur);
		if(pos == nums.length) {
			return;
		}
		for(int i = pos; i < nums.length; i++) {
			cur *= nums[i];
			dfs(ans,nums,i+1,cur);
			cur /= nums[i];
		}
		return;
	}
	private void dfs_without_hashSet(List<Integer> ans, int[] nums, int pos, int cur) {
		ans.add(cur);
		if(pos == nums.length)
			return;
		for(int i = pos; i < nums.length; i++) {
			if(i > pos && nums[i] == nums[i-1])
				continue;
			cur *= nums[i];
			dfs_without_hashSet(ans,nums,i+1,cur);
			cur /= nums[i];
		}
		return;
	}

}
