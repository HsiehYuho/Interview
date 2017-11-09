package fb;


public class Add_K_nary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_K_nary sol = new Add_K_nary();
		sol.exe();
	}
	// 0 1 2 3 4 5 6 10 11 16 20
	private void exe() {
		System.out.println(convert("6","1"));
		return;
	}
	private String convert(String s1, String s2) {
		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		int idx1 = s1.length()-1;
		int idx2 = s2.length()-1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(idx1 >= 0 || idx2 >= 0) {
			int n1 = 0;
			if(idx1 >= 0)	
				n1 = char1[idx1]-'0';
			int n2 = 0;
			if(idx2 >= 0)
				n2 = char2[idx2]-'0';
			int sum = (n1+n2+carry);
			carry = sum / 7;
			sb.append(sum % 7);
			idx1--;
			idx2--;
		}
		if(carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	
	}	
//	private int charToInt(char c) {
//		
//		
//	}
//	private char intToChar(int i) {
//		
//	}
	
	
	
	
//		int carry = 0;
//		int sum = 0;
//		int idx1 = s1.length()-1;
//		int idx2 = s2.length()-1;
//		StringBuilder sb = new StringBuilder();
//		while(idx1 >= 0 || idx2 >= 0) {
//			if(idx1 >= 0) {
//				sum += charToInt(s1.charAt(idx1--));
//			}
//			if(idx2 >= 0)
//				sum += charToInt(s2.charAt(idx2--));
//			sum += carry;
//			carry = sum/16;
//			System.out.println(intToChar(sum % 16));
//			sb.insert(0, intToChar(sum % 16));
//			sum = 0;
//		}		
//		if(carry != 0)
//			sb.insert(0, intToChar(carry%16));
//		return sb.toString();
//	
//	}
//	private int charToInt(char c) {
//		int lowerTen = c - '0';
//		if(lowerTen >= 0 && lowerTen < 10)
//			return lowerTen;
//		else {
//			int overTen = c - 'A';
//			return overTen + 10;
//		}	
//	}
//	private char intToChar(int i) {
//		char lowerTen = '0';
//		char overTen = 'A';
//		if(i < 10) {
//			lowerTen += i;
//			return lowerTen;
//		}
//		else {
//			overTen += (i-10);
//			return overTen;
//		}
//	}
	
	

}
