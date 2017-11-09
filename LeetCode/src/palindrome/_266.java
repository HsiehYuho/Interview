package palindrome;

import java.util.HashSet;

public class _266 {
	public static void main(String[] args) {
		_266 a = new _266();
		a.exe();
	}
	public void exe() {
		return;
	}
    public boolean canPermutePalindrome(String s) {
    		HashSet<Character> set = new HashSet<>();
    		char[] chars = s.toCharArray();
    		for(int i = 0; i < chars.length; i++) {
    			if(set.contains(chars[i]))
    				set.remove(chars[i]);
    			else
    				set.add(chars[i]);
    		}
    		return set.size() == 0 || set.size() == 1;
    }	
}
