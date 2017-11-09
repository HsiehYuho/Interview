package fb;

public class Multiply_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multiply_Strings a = new Multiply_Strings();
		a.exe();
	}
	public void exe() {
		return;
	}
	// backward - checking number can be added 
	// using index(i,j) = indices(i+j,i+j+1)
	public String mul(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return "";
		}
		int len1 = s1.length(), len2 = s2.length();
		int[] indices = new int[len1+len2];  // padding by one!!!
		for(int i = len1-1;i  >= 0; i++) {
			for(int j = len2-1; j >= 0; j++) {
				int n1 = s1.charAt(i) - '0';
				int n2 = s2.charAt(j) - '0';
				int sum = n1*n2;
				int pos1 = i+j, pos2 = i+j+1;
				sum += indices[pos2];
				indices[pos1] += sum/10; // one is += and the other is = 
				indices[pos2] = sum%10;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean atStart = true;
		for(int p = 0; p < indices.length; p++) {
			if(atStart && indices[p] != 0)
				atStart = false;
			if(!atStart)
				sb.append(indices[p]);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

}
