package dp;

public class _600 {
	public static void main(String[] args) {
		_600 a = new _600();
		a.exe();
	}
	public void exe() {
		System.out.println(findIntegers(0));
		return;
	}
    public int findIntegers(int num) {
    		StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
    		int n = sb.length();
    		int[] endWith0 = new int[n];
    		int[] endWith1 = new int[n];
    		endWith0[0] = 1;
    		endWith1[0] = 1;
    		for(int i = 1; i < n; i++) {
    			endWith0[i] = endWith0[i-1]+endWith1[i-1];
    			endWith1[i] = endWith0[i-1];
    		}
    		int res = endWith0[n-1] + endWith1[n-1];
    		// subtracting 
    		for(int i = n-2; i >= 0; i--) {
    			if(sb.charAt(i) == '1' && sb.charAt(i+1) == '1')
    				break;
    			if(sb.charAt(i) == '0' && sb.charAt(i+1) == '0')
    				res -= endWith1[i]; // because 01 is bigger than 00, so we have to subtract it
    		}
    		return res;
    }	
}
