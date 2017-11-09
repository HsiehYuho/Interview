package oscar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word_Break sol = new Word_Break();
		sol.exe();

	}
	private void exe() {
		String[] dic = new String[] {"dog", "cats", "sand", "cat", "and"};
		String s =  "catsanddog";
		List<List<String>> res = findAllCombination(dic,s);
		for(List<String> list : res) {
			for(String word : list)
				System.out.print(word + " ");
			System.out.println();
		}
		return;
	}
	private List<List<String>> findAllCombination(String[] dic, String s){
		HashSet<String> bank = new HashSet<>();
		int max = -1;
		for(String word : dic) {
			bank.add(word);
			max = Math.max(word.length(), max);
		}
		List<List<String>> res = new ArrayList<>();
		dfs(s,bank,max,res,new ArrayList<>());
		return res;
	}
	private void dfs(String s, HashSet<String> bank, int max, List<List<String>> res, List<String> cur) {
		if(s.length() == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for(int i = 0; i <= max && i <= s.length(); i ++) {
			String sub = s.substring(0, i);
			if(bank.contains(sub)) {
				cur.add(sub);
				dfs(s.substring(i),bank,max,res,cur);
				cur.remove(cur.size()-1);
			}
		}
	}

}
