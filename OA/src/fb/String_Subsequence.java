package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String_Subsequence sol = new String_Subsequence();
		sol.exe();
	}
	private void exe() {
		List<String> res = subset("aab");
		for(String s : res)
			System.out.println(s);
		return;
	}
	private List<String> subset(String s){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		List<String> res = new ArrayList<>();
		dfs(res,chars,0,new StringBuilder());
		return res;
	}
	private void dfs(List<String> res, char[] chars, int pos, StringBuilder sb) {
		res.add(sb.toString());
		if(pos == chars.length)
			return;
		for(int i = pos; i < chars.length; i++) {
			if(i > pos && chars[i] == chars[i-1])
				continue;
			sb.append(chars[i]);
			dfs(res,chars,i+1,sb);
			sb.deleteCharAt(sb.length()-1);
		}
		return;
	}

}
