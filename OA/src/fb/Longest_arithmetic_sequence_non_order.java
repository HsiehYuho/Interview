package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Longest_arithmetic_sequence_non_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_arithmetic_sequence_non_order sol = new Longest_arithmetic_sequence_non_order();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {7,4,5,6,8,10,1,-2,11,-5,-8};
		System.out.println(findLongest(nums));
		return;
	}
	private int findLongest(int[] nums) {
		int n = nums.length;
		HashMap<Integer, List<int[]>> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				int dif = nums[j] - nums[i];
				if(!map.containsKey(dif))
					map.put(dif, new ArrayList<>());
				List<int[]> list = map.get(dif);
				list.add(new int[] {i,j});
			}
		}
		int max = 0;
		int[] record;
		for(int key : map.keySet()) {
			List<int[]> list = map.get(key);
			record = new int[n];
			for(int[] idx : list) {
				record[idx[1]] = record[idx[0]]+1;
			}
			for(int r : record)
				max = Math.max(r, max);
		}
		return max+1;
	}

}
