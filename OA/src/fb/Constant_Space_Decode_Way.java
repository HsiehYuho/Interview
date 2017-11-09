package fb;

public class Constant_Space_Decode_Way {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constant_Space_Decode_Way a = new Constant_Space_Decode_Way();
		a.exe();
	}
	public void exe() {
		return;
	}
	public int decode(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int n = s.length();
		int curCount = 0, preCount = 1, prepreCount = 0;
		for(int i = n-1; i >= 0; i--) {
			if(s.charAt(i) == '0') {
				prepreCount = preCount;
				preCount = 0;
				curCount = 0;
				continue;
			}
			curCount = preCount;
			if(i < n-1 && (s.charAt(i) =='1' || s.charAt(i) == '2' && s.charAt(i+1) - '0' <= 6))
				curCount += prepreCount;
			prepreCount = preCount;
			preCount = curCount;
		}
		return curCount;
		
	}

}
