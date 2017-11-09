package fb;

public class Get_First_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Get_First_Valid_Parentheses sol = new Get_First_Valid_Parentheses();
		sol.exe();
	}
	private void exe() {
		System.out.print(remove("(()())))"));
		return;
	}
	private String remove(String s) {
		String firstS = isValid(s,new char[] {'(',')'});
		StringBuilder sb = new StringBuilder(firstS);
		String tmp = sb.reverse().toString();
		String secondS = isValid(tmp,new char[] {')','('});
		String ans = new StringBuilder(secondS).reverse().toString();
		return ans;
	}
	private String isValid(String s, char[] p) {
		int count = 0;
		int idx = 0;
		int n = s.length();
		while(idx < n) {
			char c = s.charAt(idx);
			if(c == p[0])
				count++;
			if(c == p[1])
				count--;
			if(count < 0) {
				s = s.substring(0, idx) + s.substring(idx+1,n);
				count = 0;
				n--;
				idx--; // important because we remove the idx so go backward
			}
			idx++;
		}
		return s;
	}

}
