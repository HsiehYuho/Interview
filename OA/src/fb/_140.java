package fb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _140 {
	public static void main(String[] args) {
		_140 a= new _140();
		a.exe();
	}
	public void exe() {
		return;
	}
    public List<String> wordBreak(String s, List<String> wordDict) {
    		HashMap<String, List<String>> map = new HashMap<>();
    		return dfs(s,wordDict,map);
    }
    // use dfs + hashmap to memorize, sublist from the list to go through it
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map){
    		if(map.containsKey(s))
    			return map.get(s);
    		List<String> res = new LinkedList<>();
    		if(s.length() == 0) {
    			res.add("");
    			return res;
    		}
    		for(String sub : wordDict) {
    			if(s.startsWith(sub)) {
    				List<String> subList = dfs(s.substring(sub.length()),wordDict,map);
    				for(String subString : subList) 
    					res.add(sub + (subString.length() == 0 ? "" : " ") + subString); // do determine how to append
//    				map.put(sub,subList);  not this
    			}	
    		}
    		map.put(s, res); // should be this
    		return res;
    }
}
