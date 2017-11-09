package arithmetic;

import java.util.HashMap;

public class _446 {
	public static void main(String[] args) {
		_446 a = new _446();
		a.exe();
	}
	public void exe() {
		System.out.println(numberOfArithmeticSlices(new int[] {2,4,6,8,10}));
	}
    public int numberOfArithmeticSlices(int[] A) {
    		@SuppressWarnings("unchecked")
			HashMap<Integer,Integer>[] map = new HashMap[A.length]; // [index,distance] , count
        int sum = 0;
        for(int i = 0; i < A.length; i++)
        		map[i] = new HashMap<Integer,Integer>();
    		for(int i = 0; i < A.length; i++) {
    			map[i] = new HashMap<>(i);
        		for(int j = 0; j < i;j++) {
        			long dis = (long)A[i] - A[j];
        			if(dis > Integer.MAX_VALUE || dis <= Integer.MIN_VALUE)
        				continue;
        			int d = (int)dis;
        			int c1 =  map[i].getOrDefault(d, 0);
        			int c2 = map[j].getOrDefault(d, 0);
        			sum += c2;
        			map[i].put(d,c1+c2+1);
        		}
        }
    		return sum;
    }
	
}
