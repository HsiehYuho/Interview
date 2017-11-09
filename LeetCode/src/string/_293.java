package string;

import java.util.ArrayList;
import java.util.List;

public class _293 {
	public static void main(String[] args) {
		_293 a = new _293();
		a.exe();
	}
	public void exe() {
		List<String> list = generatePossibleNextMoves("+++----++++");
		for(String s : list) {
			System.out.println(s);
		}
		return;
	}
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 1; i < chars.length; i++) {
        		if(chars[i] == '+' && chars[i-1] == '+') {
        			chars[i] = '-';
        			chars[i-1] = '-';
        			list.add(new String(chars));
        			chars[i] = '+';
        			chars[i-1] = '+';
        		}
        }
        return list;
    }	
}
