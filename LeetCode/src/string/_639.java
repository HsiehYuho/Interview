package string;

public class _639 {
	public static void main(String[] args) {
		_639 a = new _639();
		a.exe();
	}
	public void exe() {
		System.out.println(numDecodings("3*"));
		return;
	}
	public int numDecodings(String s) {
		long[] res = new long[2];
		res[0] = ways(s.charAt(0));
		if(s.length() < 2)
			return (int)res[0];
		res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0),s.charAt(1));
		for(int j = 2; j < s.length(); j++) {
			long tmp = res[1];
			res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1),s.charAt(j))) % 1000000007;
			res[0] = tmp;
		}
		return (int)res[1];
	}
	private long ways(char c) {
		if(c == '*')
			return 9;
		else if (c == '0')
			return 0;
		return 1;
	}
	private long ways(char c1, char c2) {
		String s = c1+""+c2;
		if(c1 != '*' && c2 != '*') {
			if(Integer.parseInt(s) <= 26 && Integer.parseInt(s) >= 10)
				return 1;
		}
		else if(c1 == '*' && c2 =='*') 
			return 15; // 11 ~ 26 - 20
		else if(c1 == '*') {
			if(Integer.parseInt(c2+"") >= 0 && Integer.parseInt(c2+"") <= 6)
				return 2; // *1 ~ *6
			else 
				return 1; // *7 vs *9
		}
		else {
			if(Integer.parseInt(c1+"") == 1) // 1*
				return 9;
			else if(Integer.parseInt(c1+"") == 2) // 2*
				return 6; 
		}
		return 0; //3* does not count
		
		
			
	}
}
