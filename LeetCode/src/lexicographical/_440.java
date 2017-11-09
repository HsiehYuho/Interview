package lexicographical;

public class _440 {
	public static void main(String[] args) {
		_440 a = new _440();
		a.exe();
	}
	public void exe() {
		System.out.println(findKthNumber(13233,100));
		return;
	}
    public int findKthNumber(int n, int k) {
    		int cur = 1;
    		k--;
    		while(k > 0) {
    			int step = calStep(n,cur,cur+1);
    			if(step <= k) {
    				cur++;
    				k -= step;
    			}
    			else {
    				cur *= 10;
    				k--;
    			}
    		}
    		return cur;
    }
    private int calStep(int n, int n1, int n2) { // calculate the cur node and the cur+1 node steps
    		int step = 0;
    		while( n1 <= n) { // most brilliant part
    			step += Math.min(n+1, n2) - n1;
    			n1 *= 10;
    			n2 *= 10;
    		}
    		return step;
    }
}

