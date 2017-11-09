package string;

public class _466 {
	public static void main(String[] args) {
		_466 a = new _466();
		a.exe();
	}
	public void exe() {
		System.out.println(getMaxRepetitions("abacb",6,"bcaa",1));
		return;
	}
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    		int[] repeatCount = new int[s2.length()+1]; // PigeonHole, must find same nextIndex in this period
    		int[] nextIndex = new int[s2.length()+1];
    		int j = 0, count = 0;
    		for(int k = 1; k <= n1; k++) { // not k = 0; k < n1; k++
    			for(int i = 0; i < s1.length(); i++) {
    				if(s1.charAt(i) == s2.charAt(j))
    					j++;
    				if(j == s2.length()) {
    					j = 0;
    					count++;
    				}
    			}
    			repeatCount[k] = count; // kth item
    			nextIndex[k] = j;
    			for(int start = 0; start < k; start++) {
    				if(nextIndex[start] == j) {
    					int preCount = repeatCount[start];
    					int midCount = (repeatCount[k] - repeatCount[start]) * (n1 - start) / (k-start);
    					int sufCount = (repeatCount[start + (n1-start) % (k-start)]) - repeatCount[start];
    					return (preCount+midCount+sufCount) / n2;
    				}
    			}
    		}
    		return repeatCount[n1]/n2;
    }
}
