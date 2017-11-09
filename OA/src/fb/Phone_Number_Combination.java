package fb;

import java.util.ArrayList;
import java.util.List;

public class Phone_Number_Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone_Number_Combination sol = new Phone_Number_Combination();
		sol.exe();
	}
	private void exe() {
		List<String> res= allCombination("ABC");
		for(String s : res)
			System.out.println(s);
		return;
	}
	private List<String> allCombination(String s){
		String[] map = new String[] {"!@#","%","^&"}; // represent A = !@#, B = % C = ^&
		List<String> res = new ArrayList<>();
		dfs(res,map,s,0,"");
		return res;
	}
	private void dfs(List<String> res, String[] map, String s, int pos, String cur) {
		if(pos == s.length()) {
			res.add(new String(cur));
			return;
		}
		String candidate = map[s.charAt(pos) - 'A'];
		for (int i = 0; i < candidate.length(); i++) {
			cur += candidate.charAt(i);
			dfs(res, map, s, pos + 1, cur);
			cur = cur.substring(0, cur.length() - 1);
		}
		return;
	}
}
