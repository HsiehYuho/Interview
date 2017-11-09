package fb;

import java.util.ArrayList;
import java.util.List;

public class Add_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Operator a = new Add_Operator();
		a.exe();
	}
	private void exe() {
		String s = "1010";
		List<String> res = ways(s,0);
		for(String ans : res)
			System.out.println(ans);
		return;
	}
	private List<String> ways(String s, int target) {
		List<String> res = new ArrayList<>();
		dfs(s,0,target,"",res);
		return res;
		
	}
	private void dfs(String s, int pos, int remains, String cur, List<String> res) {
		if(pos == s.length()) {
			if(remains == 0) {
				res.add(new String(cur));
			}
			return;
		}
		for(int i = pos+1; i <= s.length(); i++) {
			if(i != pos+1 && s.charAt(pos) == '0')
				return;
			String sub = s.substring(pos, i);
			int val = Integer.valueOf(sub);
			if(pos == 0) {
				dfs(s,i,remains-val,sub,res);
			}
			else {
				dfs(s,i,remains-val,cur+"+"+sub,res);
				dfs(s,i,remains+val,cur+"-"+sub,res);
			}
		}
		
	}

}
