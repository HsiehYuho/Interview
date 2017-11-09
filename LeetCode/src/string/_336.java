package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _336 {
	public static void main(String[] args) {
		_336 a = new _336();
		a.exe();
	}
	public void exe() {
		String[] words = new String[] {"a", ""};
		List<List<Integer>> res  = palindromePairs(words);
		for(List<Integer> list : res) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		return;
	}
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if(words.length < 2)
			return res;
		Map<String, Integer> map = new HashMap<>(); // stort the word and its index, faster than naive;
		for(int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for(int i = 0; i < words.length;i++) {
			for(int j = 0; j <= words[i].length(); j++) { // important, j <= length to avoid ""
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				addPar(s1,s2,i,map,res,false);
				if(s2.length() != 0) // important to avoid duplicate
					addPar(s2,s1,i,map,res,true);				
			}
		}
		return res;
	}
	private void addPar(String s1, String s2, int index, Map<String,Integer> map, List<List<Integer>> res, boolean reverse) {
		if(isPar(s1)) {
			s2 = new StringBuilder(s2).reverse().toString();
			int value = map.getOrDefault(s2, -1);
			if(value != index && value != -1) { // to avoid duplicate
				List<Integer> ans = new ArrayList<>();
				if(reverse) {
					ans.add(index);
					ans.add(value);
				}
				else {
					ans.add(value);
					ans.add(index);					
				}
				res.add(ans);
			}
		}		
		return;
	}
	private boolean isPar(String s) {
		int left = 0, right = s.length()-1;
		while(left < right) {
			if(s.charAt(left++) != s.charAt(right--))
				return false;
		}
		return true;
	}
}
