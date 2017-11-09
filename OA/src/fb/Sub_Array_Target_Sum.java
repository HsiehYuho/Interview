package fb;

import java.util.HashSet;

public class Sub_Array_Target_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub_Array_Target_Sum sol = new Sub_Array_Target_Sum();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,2,5};
		int target = 3;
		System.out.println(getTarget(nums,target));
		return;
	}
	private boolean getTarget(int[] nums, int target) {
		HashSet<Integer> set = new HashSet<>();
		int cur = 0;
		set.add(0);
		for(int n : nums) {
			cur += n;
			if(set.contains(cur-target))
				return true;
			set.add(cur); // 最後才update

		}
		return false;
	}

}
