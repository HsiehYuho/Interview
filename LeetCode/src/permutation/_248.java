package permutation;

public class _248 {
	private static final char[][] pairs = {{'0','0'},{'1','1'},{'8','8'},{'6','9'},{'9','6'}};
	public static void main(String[] args) {
		_248 a = new _248();
		a.exe();
	}
	public void exe() {
		System.out.println(strobogrammaticInRange("10","20"));
		return;
	}
    public int strobogrammaticInRange(String low, String high) {
    		int[] count = new int[] {0};
    		for(int i = low.length(); i <= high.length(); i++) {
    			char[] c = new char[i];
    			dfs(c,low, high,0,i-1,count);
    		}
    		return count[0];
    }
    private void dfs(char[] c, String low, String high, int left ,int right, int[] count) {
    		if(left > right) {
    			String s = new String(c);
    			if((s.length() == low.length() && s.compareTo(low) < 0)
    					|| (s.length() == high.length() && s.compareTo(high) > 0))
    				return;
    			count[0]++;
    			return;
    		}
    		for(char[] p : pairs) {
    			c[left] = p[0];
    			c[right] = p[1]; 
    			if(left == right && p[1] != p[0]) // ged rid of XX6XX, XX9XX
    				continue;
    			if(c.length != 1 && c[0] == '0') // get rid of 0XXX0, cannot put it at the forehead of c[left] and c[right]
    				continue;
    			dfs(c,low,high,left+1,right-1,count);
    		}
    }
}
