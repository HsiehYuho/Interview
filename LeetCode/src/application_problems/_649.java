package application_problems;

public class _649 {
	public static void main(String[] args) {
		_649 a= new _649();
		a.exe();
	}
	public void exe() {
		System.out.print(predictPartyVictory("DRRDRDRDRDDRDRDR"));
		return;
	}
	public String predictPartyVictory(String senate) {
		char[] chars = senate.toCharArray();
		int d = 0, r = 0;
		while(true) {
			boolean change = false;
			StringBuilder sb = new StringBuilder();
			for(char c : chars) {
				if(c == 'D') {
					if(r > 0) {
						r--; 
						change = true;
					}
					else {
						d++;
						sb.append(c);
					}
				}
				else {
					if(d > 0) {
						d--;
						change = true;
					}
					else {
						r++;
						sb.append(c);
					}
				}
			}
			if(change) {
				chars = sb.toString().toCharArray();
			}
			else {
				return sb.charAt(0) == 'D' ? "Dire" : "Radiant";
			}
		}
	}		
}
