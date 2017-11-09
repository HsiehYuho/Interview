package dp;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class _472 {
	public static void main(String[] args) {
		_472 a = new _472();
		a.exe();
	}
	public void exe() {
		return;
	}
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> res = new ArrayList<>();
	    Set<String> preWords = new HashSet<>();
	    Comparator<String> cmp = new Comparator<String>() {
    		public int compare(String s1, String s2) {
    			if(s1.length() == s2.length())
    				return s1.compareTo(s2);
    			return s1.length() - s2.length();
    		}};
	    Arrays.sort(words,cmp);
	    for(int i = 0 ; i < words.length; i++) {
	    		if(i > 0 && words[i].equals(words[i-1]))
	    			continue;
	    		if(canForm(words[i],preWords))
	    			res.add(words[i]);
	    		preWords.add(words[i]);
	    			
	    }
	    return res;
	}
	private boolean canForm(String s, Set<String> dic) {
		if(dic.size() == 0)
			return false;
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(!dp[j]) continue;
				if(dic.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
}
