package string;


public class _316 {
	public static void main(String[] args) {
		_316 a = new _316();
		a.exe();
	}
	public void exe() {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
		return;
	}
    public String removeDuplicateLetters(String s) {
    		int[] charRecord = new int[26];
    		int pos = 0; // store the smallest, leftmost character position
    		for(int i = 0; i < s.length(); i++)
    			charRecord[s.charAt(i)-'a']++;
    		for(int i = 0; i < s.length(); i++) {
    			if(s.charAt(i) < s.charAt(pos))
    				pos = i;
    			if( --charRecord[s.charAt(i)-'a'] == 0)
    				break;
    		}
    		return s.length() == 0 ? "" : s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));    		
    }
}
