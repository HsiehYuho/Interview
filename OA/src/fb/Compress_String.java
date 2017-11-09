package fb;

public class Compress_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compress_String sol = new Compress_String();
		sol.exe();
	}
	// aabbcccdd
	private void exe() {
		String s = "aabbcccdd";
		System.out.println(compress(s));
		return;
	}
	private String compress(String s) {
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1; 
		char pre = '#';
		for(int i = 0; i < chars.length; i++) {
			if(pre != chars[i]) {
				if(pre != '#')
					sb.append(pre+""+count);
				count = 1;
				pre = chars[i];
			}
			else{
				count++;
			}
		}
		sb.append(pre+""+count);
		return sb.toString();
	}
}
