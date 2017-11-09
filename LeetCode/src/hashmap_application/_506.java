package hashmap_application;

import java.util.Arrays;
import java.util.HashMap;

public class _506 {
	public static void main(String[] args) {
		_506 a = new _506();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1,5,3,2,6,7};
		String[] res = findRelativeRanks(nums);
		for(String str : res)
			System.out.print(str + " ");
		return;
	}
	public String[] findRelativeRanks(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int[] copy = Arrays.copyOf(nums,nums.length);
		Arrays.sort(copy);
		int rank = 1;
		for(int i = copy.length-1; i>= 0; i--) {
			map.put(copy[i], rank++);
		}
		String[] res =new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			int str = map.get(nums[i]);
			if(str > 3)
				res[i] = str + "";
			else {
				if(str == 1)
					res[i] = "Gold Medal";
				else if(str == 2)
					res[i] = "Silver Medal";
				else if(str == 3)
					res[i] = "Bronze Medal";
			}
		}
		return res;
	}
}
