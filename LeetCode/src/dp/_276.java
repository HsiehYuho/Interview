package dp;

public class _276 {
	public static void main (String[] args) {
		_276 a = new _276();
		a.exe();
	}
	public void exe() {
		System.out.println(numWays(5,3));
		return;
	}
	// this means no more than TWO ADJACENT pants painted same color
    public int numWays(int n, int k) {
        if(n == 0 || k == 0)
            return 0;
        if(n == 1)
            return k;
    		int difInLas = k * (k-1);
    		int sameInLas = k * 1;
    		for(int i = 2; i < n; i++) {
    			int tmp = difInLas;
    			difInLas = (sameInLas+ difInLas)*(k-1);
    			sameInLas = tmp; // it got no choice but follow the previous paint		
    		}
    		return sameInLas+ difInLas;
    }
}
