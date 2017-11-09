package permutation;

public class _567 {
	public static void main(String[] args) {
		_567 a = new _567();
		a.exe();
	}
	public void exe() {
		System.out.println(checkInclusion("adc","dcda"));
		return;
	}
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length() == 0)
			return true;
		if(s2.length() == 0)
			return false;
		boolean[] record = new boolean[26];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int n = s1.length();
		for(int i = 0; i < n; i++)
			record[c1[i] - 'a'] = true;
		for(int i = 0; i < c2.length; i++) {
			if(record[c2[i]-'a'])
				if(i + n <= c2.length && isPermute(s2.substring(i,i+n),c1))
					return true;
		}
		return false;
    }
	private boolean isPermute(String s2, char[] c1) {
		if(s2.length() != c1.length) {
			return false;
		}
		char[] c2 = s2.toCharArray();
		int[] record = new int[26];
		for(int i = 0; i < c1.length; i++) {
			record[c1[i] -'a']++;
			record[c2[i] -'a']--;
		}
		for(int i = 0; i < 26; i++) {
			if(record[i] != 0)
				return false;
		}
		return true;
		
	}
}
