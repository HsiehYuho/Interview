package string;

public class _294 {
	public static void main(String[] args) {
		_294 a = new _294();
		a.exe();
	}
	public void exe() {
		System.out.println(canWin("+++++"));
		return;
	}
	// we should do it memorize ! 
	public boolean canWin(String s) {
		char[] chars = s.toCharArray();
		for(int i = 1; i < chars.length; i++) {
			if(chars[i-1] == '+' && chars[i] == '+') {
				chars[i-1] = '-';
				chars[i] = '-';
				if(!canWin(new String(chars)))
					return true;
				chars[i-1] = '+';
				chars[i] = '+';
			}
		}
		return false;
    }
}
