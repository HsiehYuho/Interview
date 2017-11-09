package string;

public class _186 {
	public static void main(String[] args) {
		_186 a = new _186();
		a.exe();
	}
	public void exe() {
		char[] s = new char[] {'a','b','c'};
		reverseWords(s);
		for(char c : s) {
			System.out.print(c);
		}
		return;
	}
    public void reverseWords(char[] s) {
    		reverse(s,0,s.length-1);
    		int start = 0;
    		for(int i = 0; i < s.length; i++) {
    			if(s[i] == ' ') {
    				reverse(s,start,i-1);
    				start = i+1;
    			}
    		}
    		reverse(s,start,s.length-1);
    		return;
    }
    private void reverse(char[] s, int start, int end) {
    		int left = start, right = end;
    		while(left < right) {
    			char tmp = s[left];
    			s[left] = s[right];
    			s[right] = tmp;
    			left++;
    			right--;
    		}
    		return;
    }
}
