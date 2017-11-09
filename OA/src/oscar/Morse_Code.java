package oscar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Morse_Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Morse_Code sol = new Morse_Code();
		sol.exe();
	}
	private void exe() {
		String s = "...-...";
		List<String> res = count(s);
		for(String decode : res) {
			System.out.println(decode);
		}
	}
	private List<String> count(String s) {
		HashMap<String,Character> map = new HashMap<>();
		String[] morse = new String[] {".-","-...","-.-","-..",".","..-.","-.","....","..",".~",
				"-.-",".-..","~","-.","~",".~.","~.-",".-.","...","-",
				"..-","...-",".~","-..-","-.~","~.."}; // represent 0 ~ 25 character
		char counter = 'a';
		int maxLength = -1;
		for(String code : morse) {
			maxLength = Math.max(code.length(),maxLength);
			map.put(code,counter++);
		}
		ArrayList<String> res = new ArrayList<>();
		dfs(res,map,"",s,maxLength);
		return res;
		
	}
	// String is copied by reference
	private void dfs(ArrayList<String> res, HashMap<String,Character> map, String ans, String remains, int maxLength) {
		if(remains.length() == 0) {
			ans.trim();
			res.add(new String(ans));
			return;
		}
		for(int i = 1; i <= maxLength && i <= remains.length(); i++) {
			String code = remains.substring(0, i);
			if(map.containsKey(code)) {
				ans += map.get(code);
				dfs(res,map,ans,remains.substring(i),maxLength);
				ans = ans.substring(0, ans.length()-1);
			}
		}
		return;
	}
	

}
