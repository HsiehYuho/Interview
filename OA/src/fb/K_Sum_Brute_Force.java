package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class K_Sum_Brute_Force {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_Sum_Brute_Force sol = new K_Sum_Brute_Force();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,2,3,4};
		List<List<Integer>> res = findKSum(nums,2,3);
		for(List<Integer> list : res) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		return;
	}
	private static HashMap<int[],List<List<Integer>>> map = new HashMap<>();
	private List<List<Integer>> findKSum(int[] nums, int k, int target){
		return dfs(nums,k,target,0,new ArrayList<Integer>());
	}
	private List<List<Integer>> dfs(int[] nums, int k, int target, int pos, List<Integer> cur) {
		int[] kTarget = new int[] {k,target};
		if(map.containsKey(kTarget)) {
			List<List<Integer>> res = map.get(kTarget);
			for(List<Integer> list : res)
				list.addAll(cur);
			return res;
		}
		if(k == 0 && target == 0) {
			List<List<Integer>> value = new ArrayList<>();
			int[] key = new int[] {0,0};
			value.add(new ArrayList<>(cur));
			map.put(key, value);
			return value;
		}
		int[] key = new int[] {k,target};
		for(int i = pos; i < nums.length; i++) {
			cur.add(nums[i]);
			List<List<Integer>> value = dfs(nums, k-1, target-nums[i], i+1,cur);
			if(value != null) {
				for(List<Integer> list : value)
					list.addAll(cur);
			}
			if(value != null)	
				map.put(key, value);
			cur.remove(cur.size()-1);
		}
		return map.get(key);
		
			
	}
}
