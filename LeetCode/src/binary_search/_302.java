package binary_search;

public class _302 {
	public static void main(String[] args) {
		_302 a = new _302();
		a.exe();
	}
	public void exe() {
		char[][] images = new char[][] {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
		System.out.println(minArea(images,0,2));
		return;
	}
	// one of the most difficult
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
		int upMost = bisearch(image,0,x,0,n,true,true);
		int downMost = bisearch(image,x+1,m,0,n,false,true);
        int leftMost = bisearch(image,0,y,upMost,downMost,true,false);
		int rightMost = bisearch(image,y+1,n,upMost,downMost,false,false);
		return (rightMost-leftMost) * (downMost-upMost);
    }
	private int bisearch(char[][] image, int start, int end, int l , int h, boolean decrease, boolean row) {
		int left = start, right = end;
		while(left < right) {
			int mid = (left+right)/2;
			int k = l;
			while(k < h && (row ? image[mid][k] : image[k][mid]) == '0') {
					++k;
			}
			if(k < h == decrease) // decrease = true means to left and to up
				right = mid;
			else
				left = mid+1;
		}
		return left;        
	}
}
