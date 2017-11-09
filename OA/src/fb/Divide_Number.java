package fb;

public class Divide_Number {
	public static void main(String[] args) {
		Divide_Number sol = new Divide_Number();
		sol.exe();
	}
	private void exe() {
		System.out.println(divideNumber(-105,5));
		return;
	}
	private int divideNumber(int a, int b) {
		if(b == 0)
			return 0;
		if(a == 0) 
			return 0;
		boolean neg = false;
		if((a * b) < 0)
			neg = true;
		a = Math.abs(a);
		b = Math.abs(b);
		if(a < b)
			return 0;
		int count = 1;
		int B = b;
		while(a >= B*2) {
			count *= 2;
			B *= 2;
		}
		return (count + divideNumber((a-B),b)) * (neg ? -1 : 1);  
	}
}
