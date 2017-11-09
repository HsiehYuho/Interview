package backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class _291 {
	public static void main(String[] args) {
		_291 a = new _291();
		a.exe();
	}
	public void exe() {
		String p = "aab";
		String str = "eggeggbomb";
		System.out.println(wordPatternMatch(p,str));
		return;
	}
    public boolean wordPatternMatch(String pattern, String str) {
    		HashMap<Character,String> map = new HashMap<>();
    		HashSet<String> set = new HashSet<>();
    		return findPattern(pattern,0,str,0,map,set);
    }
    private boolean findPattern(String pat, int i, String str, int j, HashMap<Character,String> map, HashSet<String> set) {
    		if(i == pat.length() && j == str.length())
    			return true;
    		if(i == pat.length() || j == str.length())
    			return false;
    		char c = pat.charAt(i);
    		// c is already in map
    		if(map.containsKey(c)) {
    			String subStr = map.get(c);
    			if(str.startsWith(subStr, j)) {
    				return findPattern(pat,i+1,str,j+subStr.length(),map,set);
    			}
    			else {
    				return false;
    			}
    		}
    		// c is not in map
    		else {
    			for(int k = j; k < str.length(); k++) { // cannot use k = j+1 cuz k can == str.length!!
    				String subP = str.substring(j, k+1); 
    				if(set.contains(subP)) // sounds weird here 
    					continue;
    				map.put(c, subP);
    				set.add(subP);
    				if(findPattern(pat,i+1,str,k+1,map,set))
    					return true;
    				// backtracking, try another combination
    				map.remove(c);
    				set.remove(subP);
    			}
    		}
    		return false;
    }
}
