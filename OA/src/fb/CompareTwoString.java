package fb;

import java.util.ArrayList;
import java.util.List;

public class CompareTwoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareTwoString sol = new CompareTwoString();
		sol.exe();
	}
	private void exe() {
		String s1 = "111119";
		String s2 = "9090";
		System.out.println(compareTo(s1,s2));
		return;
	}
	private int compareTo(String s1, String s2) {
		List<String> s1sub = cutBlock(s1);
		List<String> s2sub = cutBlock(s2);
		boolean swap = false;
		if(s1sub.size() < s2sub.size()) {
			List<String> tmp = s1sub;
			s1sub = s2sub;
			s2sub = tmp;
			swap = true;
		}
		int i;
		for(i = 0; i < s2sub.size(); i++) {
			int res = compareString(s1sub.get(i),s2sub.get(i)); 
			if( res > 0)
				return !swap ? 1 : -1;
			else if (res < 0)
				return !swap ? -1 : 1;
		}
		if (i == s1sub.size())
			return 0;
		return !swap ? 1 : -1;
	}
	private int compareString(String s1, String s2) {
		boolean s1IsDigit = Character.isDigit(s1.charAt(0));
		boolean s2IsDigit = Character.isDigit(s1.charAt(0));
		if( s1IsDigit ^ s2IsDigit) {
			if(s1IsDigit)
				return 1;
			else
				return -1;
		}
		boolean swap = false;
		if(s1.length() < s2.length()) {
			swap = true;
			String tmp = s1;
			s1 = s2;
			s2 = tmp;
		}
		if(s1IsDigit) {
			if(Integer.parseInt(s1) > Integer.parseInt(s2))
				return !swap ? 1 : -1;
			else if (Integer.parseInt(s1) < Integer.parseInt(s2))
				return !swap ? -1 : 1;			
			else 
				return 0;
		}
		else {
			return !swap ? s1.compareTo(s2) : -1 * s1.compareTo(s2);
		}
	}
	private List<String> cutBlock(String s) {
		List<String> res = new ArrayList<>();
		boolean isDigit = Character.isDigit(s.charAt(0));
		int ptr = 0;
		int pre = 0;
		while(ptr < s.length()) {
			while(ptr < s.length() && isDigit == Character.isDigit(s.charAt(ptr))){
				ptr++;
			}
			isDigit = !isDigit;
			res.add(s.substring(pre,ptr));
			pre = ptr;
		}
		return res;
	}

}
