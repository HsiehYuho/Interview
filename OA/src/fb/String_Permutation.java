package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_Permutation {
	public static void main(String[] args) {
		String_Permutation sol = new String_Permutation();
		sol.exe();
	}
	private void exe() {
		String s = "aabc";
		List<String> res = permute(s);
		for(String c : res)
			System.out.println(c);
		return;
	}
	private List<String> permute(String s){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		List<String> res = new ArrayList<>();
		compute(chars,0,res,new StringBuilder());
		return res;
	}
	private void compute(char[] chars, int pos, List<String> res, StringBuilder sb) {
		res.add(sb.toString());
		if(pos == chars.length)
			return;
		for(int i = pos; i < chars.length; i++) {
			if(i > pos && chars[i] == chars[i-1])
				continue;
			sb.append(chars[i]);
			compute(chars,i+1,res,sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}