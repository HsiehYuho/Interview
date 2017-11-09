package api_design;

import java.util.HashSet;
import java.util.Iterator;

public class _170 {
	public static void main(String[] args) {
		_170 a = new _170();
		a.exe();
	}
	public void exe() {
		return;
	}
	HashSet<Integer> set = new HashSet<>();
	HashSet<Integer> numSet = new HashSet<>();
    public void add(int number) {
        if(numSet.size()!=0) {
        		Iterator<Integer> itr = numSet.iterator();
        		while(itr.hasNext()) {
        			set.add(itr.next()+number);
        		}
        }
        else {
        		numSet.add(number);
        }
    }   
    public boolean find(int value) {
        return set.contains(value);
    }
}
