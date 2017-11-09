package fb;

public class Strange_String_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strange_String_Conversion sol = new Strange_String_Conversion();
		sol.exe();
	}
	private void exe() {
		String s= "-AA---B--C-CC-C-D-CC-D";
		System.out.println(convert(s));
		return;
	}
	private String convert(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		int ptr = 0;
		char c = '*';
		int start = -1;
		int end = -1;
		while(ptr < n) {
			while(ptr < n && chars[ptr] == '-')
				ptr++;
			if(ptr == n)
				break;
			if(chars[ptr] != c) {
				if(end != -1) {
					chars[start] = '(';
					chars[end] = ')';
				}
				start = ptr;
				end = -1;
				c = chars[ptr];
			}
			else {
				end = ptr;
			}
			ptr++;
		}
		ptr = 0; 
		boolean in = false;
		while(ptr < n) {
			if(chars[ptr] == '(') {
				in = true;
			}
			if (chars[ptr] ==')') {
				chars[ptr] = '+';
				in = false;
			}
			if(in) {
				chars[ptr] = '+';				
			}
			ptr++;
		}
		return String.valueOf(chars);
	}
	

}
