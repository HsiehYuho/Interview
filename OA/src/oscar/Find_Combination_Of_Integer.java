package oscar;

import java.util.HashSet;

public class Find_Combination_Of_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Combination_Of_Integer sol = new Find_Combination_Of_Integer();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {5,7,9};
		System.out.println(find(nums,22,new HashSet<Integer>()));
		return;
	}
	private boolean find(int[] nums, int target, HashSet<Integer> fail) {
		if(fail.contains(target))
			return false;
		if(target < 0)
			return false;
		if(target == 0)
			return true;
		fail.add(target);
		for(int i = 0; i < nums.length; i++){
			if(find(nums,target-nums[i],fail))
				return true;
		}
		return false;
	}	
}
