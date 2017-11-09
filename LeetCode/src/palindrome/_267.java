package palindrome;

import java.util.ArrayList;
import java.util.List;

public class _267 {
	public static void main(String[] args) {
		_267 a = new _267();
		a.exe();
	}
	public void exe() {
		return;
	}
    public List<String> generatePalindromes(String s) {
		int[] map = new int[256];
		char[] chars = s.toCharArray();
		int numOfOdd = 0;
		for(char c : chars) {
			map[c]++;
			numOfOdd = (map[c]&1) == 1 ? numOfOdd+1 : numOfOdd-1;
		}
		if(numOfOdd > 1)
			return new ArrayList<String>();
		String mid = "";
		int length = 0;
		for(int i = 0; i < 256; i++) {
			if((map[i]&1) == 1) {
				mid += (char)i;
				map[i]--;
			}
			map[i]/=2;
			if(map[i] != 0) {
				length += map[i];
			}
		}
		List<String> res = new ArrayList<>();
		permute(res,map,0,length, "", mid);
		return res;
    }
    private void permute(List<String> res, int[] map, int index, int length, String s, String mid){
		if(length == index) {
			StringBuilder sb = new StringBuilder(s);
			res.add(sb.toString()+mid+sb.reverse().toString());
			return;
		}
		for(int i = 0; i < 256; i++) {
			if(map[i] > 0) {
				map[i]--;
				permute(res,map,index+1,length,s+(char)i,mid);
				map[i]++;
			}
		}
}
}
