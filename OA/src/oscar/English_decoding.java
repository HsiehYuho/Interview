package oscar;

import java.util.Stack;

public class English_decoding {
	public static void main(String[] args) {
		English_decoding secret = new English_decoding();
		secret.exe();
	}
	public void exe() {
		String s = "152&";
		System.out.println(decode(s));
	}
	// Parameter s equals to input encode String
	private String decode(String s) {
		int[] freq = new int[26];
		// condition 1: 1(1)
		// condition 2: 1
		// condition 3: 23#
		// condition 4: 23#(1000)
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for(char c : chars)
			stack.push(c);
		int count = 1;
		int idxOfChar = -1;
		while(!stack.isEmpty()) {
			char c = stack.pop(); // the pop out character
			assert((c-'0') < 10 || c == '#' || c == '(' || c == ')') :  "input invalid";
			if(c == ')') {		// encounter (2) case
				count = 0;
				while(stack.peek()!= '(')
					count = (stack.pop() - '0') + count; // make (XXX) -> interger XXX
				stack.pop(); // pop out the '('
				continue;
			}
			// count the 25# case
			if (c == '#') {
				idxOfChar = 0;
				idxOfChar = stack.pop()-'0';
				idxOfChar = (stack.pop() - '0')*10 + idxOfChar;
			}
			// count the 9 case
			else {
				idxOfChar = c - '0';
			}
			freq[idxOfChar-1] += count;
			count = 1;
		}
		String res = "";
		for(int i = 0; i < 26; i++) {
			res += freq[i];
		}
		return res;
	}
}
