package string;

import java.util.ArrayList;
import java.util.List;

public class _271 {
    	public static void main(String[] args) {
    		_271 a = new _271();
    		a.exe();
    	}
    	public void exe() {
    		List<String> res = new ArrayList<>();
    		res.add("test1");
    		res.add("test2");
    		res.add("/test3");
    		String s = encode(res);
    		System.out.println(s);
    		List<String> decode = decode(s);
    		for(String tmp : decode)
    			System.out.println(tmp);
    		return;
    	}
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
        for(String s : strs) {
        		sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index = 0;
        List<String> res = new ArrayList<>();
        while(index < s.length()) {
        		int slash = s.indexOf('/', index);
        		int size = Integer.valueOf(s.substring(index,slash));
        		res.add(s.substring(slash+1,slash+size+1));
        		index = slash+size+1;
        }
        return res;
    }
}
