package palindrome;

public class _564 {
	public static void main(String[] args) {
		_564 a = new _564();
		a.exe();
	}
	public void exe() {
		System.out.println(nearestPalindromic("100"));
		return;
	}
	private long ans = 0;
	private long dif = Long.MAX_VALUE;
	private long base = 0;
	public String nearestPalindromic(String n) {
        this.base = Long.parseLong(n);
        long leftHalf = Long.parseLong(n.substring(0,(n.length()+1)/2));
        concat(leftHalf);
        concat(leftHalf+1); // upper palindrome // 99 -> 101 in this case
        concat((leftHalf+1)/10); // handle ex 9 -> 11  999->1001 
        concat(leftHalf-1); // lower palindrome
        concat((leftHalf-1)*10 + 9); // handle ex 1001 -> 999 
        return this.ans+"";
	}
	private void concat(long leftHalf) {
		String s = (new StringBuilder(leftHalf+"").reverse().toString());
		update(leftHalf+s); // handle abba
		update(leftHalf+s.substring(1)); // handle aba
		return;
	}
	private void update(String n) {
		long tmp = Long.parseLong(n);
		if(tmp == this.base)
			return;
		if(Math.abs(tmp - base) < dif || (Math.abs(tmp-base) == dif && ans > tmp)) {
			ans = tmp;
			dif = Math.abs(tmp-base);
		}
		return;
	}
}
