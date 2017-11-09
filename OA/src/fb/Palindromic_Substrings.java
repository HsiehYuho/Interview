package fb;

public class Palindromic_Substrings {
	public static void main(String[] args) {
		Palindromic_Substrings a = new Palindromic_Substrings();
		a.exe();
	}
	public void exe() {
		return;
	}
    public int countSubstrings(String s) {
    		int[] count = new int[0];
    		char[] chars = s.toCharArray();
    		for(int i = 1; i < chars.length; i++) {
    			if(chars[i] == chars[i-1])
    				count(chars,i-1,i,count);
    			else
    				count(chars,i,i,count);
    		}
    		return count[0];
    }
    private void count(char[] chars, int left , int right, int[] count) {
    		int i = left ,j = right;
    		while(i >= 0 && j < chars.length && chars[i] == chars[j]) {
    			count[0]++;
    			i++;
    			j--;
    		}
    			
    }
}
