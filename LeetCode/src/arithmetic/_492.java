package arithmetic;

public class _492 {
	public static void main(String[] args) {
		_492 a = new _492();
		a.exe();
	}
	public void exe() {
		int[] ans = constructRectangle(108);
		for(int i : ans)
			System.out.print(i + " ");
		return;
	}
	public int[] constructRectangle(int area) {
		int base = (int)Math.sqrt(area);
		int width = -1;
		for(int i = base; i > 0; i--) {
			if(area % i == 0) {
				width = i;
				break;
			}
		}
		return new int[] {area/width,width};
    }
}
