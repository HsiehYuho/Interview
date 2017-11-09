package palindrome;

public class _479 {
	public static void main(String[] args) {
		_479 a = new _479();
		a.exe();
	}
	public void exe() {
		System.out.println(largestPalindrome(2));
		return;
	}
	public int largestPalindrome(int n) {
		long maxProductN = (long)Math.pow(10, n);
		long max = maxProductN - 1;
		long minProductN = maxProductN/10;
		long min = minProductN + 1; 
		long firstHalf = max * max / maxProductN; // 9801 -> 98
		boolean found = false;
		long palindrome = 0;

		while(!found && firstHalf > 0) {
			palindrome = createPal(firstHalf);
			for(long i = max; i >= min; i--) {
				if(i * i < palindrome || (palindrome / i) > max )
					break;
				if(palindrome % i == 0) {
					found = true; 
					break;
				}
			}
			firstHalf-- ;
		}
		return (int)(palindrome % 1337);
    }
	private long createPal(long n) {
		String tmp = n + "";
		String s = new StringBuilder(tmp).reverse().toString();
		return Long.parseLong(tmp+s);
	}
}
