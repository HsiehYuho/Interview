package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ABCD_4_Sum {
	public static void main(String[] args) {
		ABCD_4_Sum sol = new ABCD_4_Sum();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,1,1,1};
		List<int[]> res= ABCD4Sum(nums);
		for(int[] i :  res) {
			for(int n : i)
				System.out.print(n + " ");
		System.out.println(" ");
		}
		
		return;
	}
	private List<int[]> ABCD4Sum(int[] nums){
		HashMap<Integer,List<List<Integer>>> map = new HashMap<>();
		List<int[]> res = new ArrayList<>();
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				int sum = nums[i]+nums[j];
				if(!map.containsKey(sum))
					map.put(sum, new ArrayList<>());
				List<List<Integer>> list = map.get(sum);
				list.add(Arrays.asList(i,j)) ;
				map.put(sum,list);
			}
		}
		for(int sum : map.keySet()) {
			if(map.get(sum).size() < 2)
				continue;
			List<List<Integer>> list = map.get(sum);
			for(int i = 0; i < list.size(); i++) {
				for(int j = i+1; j < list.size(); j++) {
					int a = list.get(i).get(0);
					int b = list.get(i).get(1);
					int c = list.get(j).get(0);
					int d = list.get(j).get(1);
					res.add(new int[] {a,b,c,d});
					res.add(new int[] {a,b,d,c});
					res.add(new int[] {b,a,c,d});
					res.add(new int[] {b,a,d,c});
				}
			}
		}
		return res;
	
	}
}
