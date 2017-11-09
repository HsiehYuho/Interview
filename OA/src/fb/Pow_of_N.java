package fb;

public class Pow_of_N {
	public static void main(String[] args) {
		Pow_of_N a = new Pow_of_N();
		a.exe();
		return;
	}
	public void exe() {
		System.out.println(myPow(-0.5,3));
		return;
	}
	// using recursive and x*x n/2 !! 
	public double myPow(double x, int n) {
		if( x == 0 )
			return 0;
		if(n == 0)
			return 1;
		if(n < 0) {
			x = 1/x;
			n = -n;
		}
		if(n % 2 == 1)
			return x * myPow(x*x,n/2);
		else
			return myPow(x*x,n/2);
    }
	
}
