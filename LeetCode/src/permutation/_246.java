package permutation;

public class _246 {
	public static void main(String[] args) {
		_246 a = new _246();
		a.exe();
	}
	public void exe() {
		System.out.println(isStrobogrammatic("101"));
		return;
	}
    public boolean isStrobogrammatic(String num) {
    		char[] chars = num.toCharArray();
    		int left = 0, right = chars.length-1;
    		while(left < right) {
    			char leftC = chars[left];
    			char rightC = chars[right];
    			if(leftC == rightC) {
    				if(!(leftC == '1' || leftC == '8' || leftC == '0')) {
    					return false;
    				}

    			}
    			else {
    				if(!(( leftC== '9' && rightC == '6' )|| (leftC == '6' && rightC =='9'))) {

    					return false;
    					
    				}
    			}
    			left++;
    			right--;
    		}
    		if(left == right) {
    			if(! (chars[left] == '1' || chars[left] == '8' || chars[left] == '0'))
    				return false;
    		}
    		return true;  		
    }
}
