package google;

public class Min_repeat_word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Min_repeat_word sol = new Min_repeat_word();
		sol.exe();
	}
	private void exe() {
		repeatTime("ab","abc");
		return;
	}
	private int repeatTime(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while(sb.length() < s2.length()) {
			sb.append(s1);
			count++;
		}
		if(sb.toString().contains(s2))
			return count;
		if(sb.append(s1).toString().contains(s2))
			return ++count;
		return -1;
	}

}
