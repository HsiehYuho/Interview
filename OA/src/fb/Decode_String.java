package fb;

import java.util.Stack;

public class Decode_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decode_String a = new Decode_String();
		a.exe();
		return;
	}
	public void exe() {
		System.out.println(decodeString("3[a2[b]]"));
	}
	public String decodeString(String s) {
		Stack<String> res = new Stack<>();
		Stack<Integer> num = new Stack<>();
		int idx = 0;
		int n = s.length();
		int k = 0;
		String str = "";
		while(idx < n) {
			char c = s.charAt(idx++);
			// there may be multiple numbers
			if(Character.isDigit(c)) {
				k = k * 10 + c-'0';
			}
			else if (c == '[') {
				num.push(k);
				k = 0;
				res.push(str);
				str = "";
			}
			else if (c == ']') {
				int tmpNum = 1;
				if(num.size() != 0)
					tmpNum = num.pop();
				String ans = "";
				if(res.size() != 0)
					 ans = res.pop();
				for(int i = 0; i < tmpNum; i++)
					ans += str;
				str = ans; // important, pass the cur string to next layer
			}
			else
				str += c;
		}
		return str;
    }

}
