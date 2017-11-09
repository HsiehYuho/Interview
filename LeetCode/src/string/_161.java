package string;

public class _161 {
	public static void main(String[] args) {
		_161 a = new _161();
		a.exe();
	}
	public void exe() {
		System.out.println(isOneEditDistance("abc","ac"));
		return;
	}
	// only three types 
	// 1. same length with 1 different word
	// 2. delete from either s or t
	// 3. add from either s or t
    public boolean isOneEditDistance(String s, String t) {
    		int n = Math.min(s.length(), t.length());
    		for(int i = 0; i < n; i++) {
    			if(s.charAt(i) != t.charAt(i)) {
    				// same length
    				if(s.length() == t.length()) {
    					return s.substring(i+1).equals(t.substring(i+1));
    				}
    				// different length
    				else if (s.length() < t.length()) {
    					return s.substring(i).equals(t.substring(i+1));
    				}
    				else {
    					return t.substring(i).equals(s.substring(i+1));
    				}
    			}
    		}
    		return Math.abs(s.length()-t.length()) == 1;
    }
}
