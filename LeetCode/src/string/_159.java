package string;

import java.util.HashMap;

public class _159 {
	public static void main(String[] args) {
		_159 a= new _159();
		a.exe();
	}
	public void exe() {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eebaaabbesaaaaaaaeeeeeeee"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("abc"));

		return;

	}
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    		int lPtr = 0, rPtr = 0;
    		int max = 0;
    		char[] chars = s.toCharArray();
    		HashMap<Character,Integer> map = new HashMap<>();
    		while(rPtr < chars.length) {
    			while(rPtr < chars.length && map.size() < 3) {
    				char c = chars[rPtr];
    				map.put(c, map.getOrDefault(c, 0)+1);
    				rPtr++;
    			}
    			if(rPtr == chars.length && map.size() != 3)
    				max = Math.max(max,rPtr - lPtr);
    			else
    				max = Math.max(max,rPtr-lPtr-1);
    			while(map.size() > 2) {
    				char c = chars[lPtr];
    				map.put(c, map.get(c)-1);
    				if(map.get(c) == 0)
    					map.remove(c);
    				lPtr++;
    			}
    		}
    		return max;   
    }
}
