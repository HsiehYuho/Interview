package fb;

import java.util.HashMap;

public class Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Window_Substring a = new Minimum_Window_Substring();
		a.exe();
	}
	public void exe() {
		return;
	}
	public String minWindow(String s, String t) {
		HashMap<Character,Integer> map = new HashMap<>();
		// record all the target character numbers
		// source "CFFS", target "CFFS" 
		if(t.length() == 0 || s.length() == 0)
			return "";		
		int count = 0;
		for(int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(!map.containsKey(c))
				count++;
			map.put(c, map.getOrDefault(c,0)+1);
		}
		// leftPtr and rightPtr compose the window
		int leftPtr = 0, rightPtr = 0;
		int minLength = Integer.MAX_VALUE;
		String ans = "";
		while(rightPtr < s.length() && leftPtr <= rightPtr) {
			// move the rightPtr at first
			while(count > 0 && rightPtr < s.length()) {
				char c = s.charAt(rightPtr);
				if(map.containsKey(c)) {
					if(map.get(c) == 1) 
						count--;
					map.put(c, map.get(c)-1);
				}
				rightPtr++;
			}
			// move the leftPtr at second 
			while(count == 0 && leftPtr <= rightPtr) {
				char c = s.charAt(leftPtr);
				if(map.containsKey(c)) {
					if(map.get(c) == 0)
						count++;
					map.put(c, map.get(c)+1);
				}
				leftPtr++;
			}
			// update the window length at the end when rightPtr - leftPtr < minLength 
			// abcdef  vs bce rightPtr stop at 5 -> leftPtr stop at 2 -> so the substring should be 1,5
			if(count == 1 && rightPtr <= s.length() && leftPtr <= rightPtr && leftPtr > 0) { // make sure leftPtr move
				if(minLength > (rightPtr - leftPtr)) {
					minLength = rightPtr - leftPtr;
					ans = s.substring(leftPtr-1, rightPtr);
				}
			}
		}
		return minLength == Integer.MAX_VALUE ? "" : ans;
	}

}
