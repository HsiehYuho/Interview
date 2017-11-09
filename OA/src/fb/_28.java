package fb;

public class _28 {
	public static void main(String[] args) {
		return;
	}
    public int strStr(String haystack, String needle) {
    		for(int i = 0; ; i++) { // this is for haystack index
    			for(int j = 0; ; j++) { // this is for needle
    				if(j == needle.length())
    					return i;
    				if(i+j == haystack.length())
    					return -1;
    				if(needle.charAt(j) != haystack.charAt(i+j))
    					break;
    			}
    		}
    }
}
