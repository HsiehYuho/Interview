package fb;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Evaluate_String_Add_Multiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evaluate_String_Add_Multiple sol = new Evaluate_String_Add_Multiple();
		sol.exe();
	}
	private void exe() {
		String s = "+15*10+5*2";
//		List<String> str = parseString(s);
//		for(String i : str)
//			System.out.print(i + " ");
		System.out.println(compute(s));
		return;
	}
	private int compute(String s) {
		if(s.length() == 0)
			return 0;
		List<String> list = parseString(s);
		Stack<Integer> nums = new Stack<>();
		Stack<String> op = new Stack<>();
		for(int i = 0; i < list.size(); i++) {
			String item = list.get(i);
			if(item.equals("+"))
				op.add(item);
			else if(item.equals("*")) {
				int num = nums.pop() * Integer.valueOf(list.get(i+1));
				nums.add(num);
				i++;			
			}
			else {
				nums.add(Integer.valueOf(item));
			}
		}
		int ans = 0;
		while(nums.size() != 0)
			ans += nums.pop();
		return ans;
	}
	
	private List<String> parseString(String s){
		if(s.charAt(0) == '+')
			s = s.substring(1);
		List<String> list = new ArrayList<>();
		int left = 0, right = 0;
		int n = s.length();
		while(right < n){
			char c = s.charAt(right);
			if(c != '+' && c != '*') {
				right++;
			}
			else {
				list.add(s.substring(left,right));					
				list.add(c+"");				
				left = right+1;
				right++;
			}
		}
		list.add(s.substring(left,right));
		return list;
	}

}
