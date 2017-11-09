package fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Number_Suffix_Lex_Order {
	public static void main(String[] args) {
		Number_Suffix_Lex_Order sol = new Number_Suffix_Lex_Order();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {10,20,30,25};
		int[] res = lexOrder(nums);
		for(int i : res)
			System.out.print(i+" ");
		return;
	}
	public int[] lexOrder(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		List<List<Integer>> collect = new ArrayList<>();
		HashMap<List<Integer>, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			List<Integer> ans = new ArrayList<>();
			for(int j = i; j < n; j++)
				ans.add(nums[j]);
			collect.add(ans);
			map.put(ans, i);
		}
		Collections.sort(collect,new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b) {
				for(int i = 0 ; i < Math.min(a.size(), b.size()); i++){
					if(a.get(i) != b.get(i))
						return a.get(i) - b.get(i);					
				}
				return a.size() - b.size();
			}
		});
		for(int i = 0 ; i < n; i++) {
			res[i] = map.get(collect.get(i));
		}
		return res;
	}
}
