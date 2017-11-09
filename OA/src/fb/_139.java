package fb;

import java.util.HashSet;
import java.util.List;

public class _139 {
	public static void main(String[] args) {
		_139 a = new _139();
		a.exe();		
	}
	public void exe() {
		return;
	}
	// dp to remember what you did 
	// make the sub string word by word 
	// make string index j in the front
    public boolean wordBreak(String s, List<String> wordDict) {
    		HashSet<String> set = new HashSet<>();
    		for(String i : wordDict)
    			set.add(i);
    		boolean[] dp = new boolean[s.length()+1];
    		dp[0] = true;
    		// move forward point at first
    		for(int j = 1; j < s.length()+1; j++) {
    			for(int i = 0; i < j; i++) { // when using i = j-1; i >= 0; i-- will improve performance
    				String sub = s.substring(i, j);
    				if(dp[i] && set.contains(sub)) {
    					dp[j] = true;
    					break;
    				}
    			}
    		}
    		return dp[s.length()+1];
    }
}
