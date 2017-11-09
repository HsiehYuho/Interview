package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _420 {
	public static void main(String[] args) {
		_420 a = new _420();
		a.exe();
	}
	public void exe() {
		System.out.println(strongPasswordChecker("abcdaaaaaaaaaaaaaaaaaaaaaaa"));
		return;
	}
	public int strongPasswordChecker(String s) {
	// get what missing 
		int n = s.length();
		boolean digit = false;
		boolean lower = false;
		boolean upper = false;
		char[] cr = s.toCharArray();
		for(char c : cr) {
			if(digit && lower && upper)
				break;
			if (!digit && Character.isDigit(c))
				digit = true;
			if (!lower && Character.isLowerCase(c))
				lower = true;
			if (!upper && Character.isUpperCase(c))
				upper = true;
		}
		int minReplace = (digit? 0 : 1) + (lower ? 0 : 1) + (upper ? 0 : 1);
		if(n < 6)
			return Math.max(6-n, minReplace);
		else if(n <= 20) {
			// dealing with consecutive numbers
			List<Integer> group = generateGroup(cr);
			int replace = 0;
			for(int i : group)
				replace += i/3;
			return Math.max(replace, minReplace);
		}
		else {
			// dealing with n > 20
			List<Integer> group = generateGroup(cr);
			Collections.sort(group);
			int index = 0, charCount = 0;
			while(charCount < 20 && index < group.size()) {
				charCount += group.get(index);
				index++;
			}
			while(index < group.size()) {
				group.remove(group.size()-1);
			}
			charCount = 0;
			int badGroup = 0;
			for(int i = 0; i < group.size(); i++) {
				if(group.get(i) > 20)
					group.set(i, 20);
				charCount += group.get(i);
				if(group.get(i) > 2)
					badGroup++;
			}
			int deletion = n - 20, toDelete = charCount - 20;
			int remainder = 0;
			while(toDelete > 0 && badGroup > 0) {
				for(int i = 0 ; i < index; i++) {
					if(group.get(i) > 2 && group.get(i) % 3 == remainder) {
						int del = Math.min(toDelete, remainder + 1); // cannot understand
						group.set(i, group.get(i)-del);
						toDelete -= del;
						if(group.get(i) <= 2)
							badGroup--;
						if(badGroup == 0 || toDelete == 0) {
							break;
						}
					}
				}
				remainder = ((remainder + 1) % 3);
				
			}
			int replace = 0;
			for(int i  = 0; i < group.size(); i++) {
				replace += group.get(i) / 3;
			}
			return deletion + Math.max(replace, minReplace);
		}
	}
	private List<Integer> generateGroup(char[] cr){
		List<Integer> group = new ArrayList<>();
		for(int i = 0; i < cr.length; i++) {
			int j = i;
			while(j < cr.length && cr[j] == cr[i]) {
				j++;
			}
			group.add(j-i);
			i = j;
		}
		return group;
	}
}
