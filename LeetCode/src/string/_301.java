package string;

import java.util.ArrayList;
import java.util.List;

public class _301 {
	public static void main(String[] args) {
		_301 a = new _301();
		a.exe();
	}
	public void exe() {
		List<String> res = removeInvalidParentheses("()())()"); 
		for(String s : res)
			System.out.println(s);
		return;
	}
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        remove(s,0,0,new char[] {'(',')'},res);
        return res;
    }
	private void remove(String s, int lastI, int lastJ,char[] par, List<String> res) {
		for(int count = 0, i = lastI; i < s.length(); i++) {
			if(s.charAt(i) == par[0])
				count++;
			if(s.charAt(i) == par[1])
				count--;
			if(count >= 0)
				continue;
			for(int j = lastJ; j <= i; j++) { // delete from j point
				if(s.charAt(j) == par[1] && (j == lastJ || s.charAt(j-1) != par[1]))
					remove(s.substring(0, j)+s.substring(j+1,s.length()),i,j,par,res); // i should mean i+1, j should mean j+1, however, it is shorten by 1	
			}
			return;
		}
		String ss = new StringBuilder(s).reverse().toString();
		if(par[0] == '(') {
			remove(ss,0,0,new char[] {')','('},res);
		}
		else
			res.add(ss);
			
	}
	
}
