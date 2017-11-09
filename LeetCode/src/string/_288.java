package string;

import java.util.HashMap;

public class _288 {
	public static void main(String[] args) {
		_288 a = new _288();
		a.exe();
	}
	public void exe() {
		String[] dic = new String[] {"deer", "door", "cake", "card"};
		ValidWordAbbr(dic);
		System.out.println(isUnique("dear"));
		System.out.println(isUnique("cart"));
		System.out.println(isUnique("cane"));
		System.out.println(map.get(abre("deer")));


		return;
	}
	HashMap<String,String> map = new HashMap<>(); 
    public void ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
        		String abr = abre(s);
        		if(map.containsKey(abr) && map.get(abr) != null && !map.get(abr).equals(s)) {
        			map.put(abr, null);
        		}
        		else {
            		map.put(abr,s);        			
        		}
        	
        }
    }
    
    public boolean isUnique(String word) {
    		String abreWord = abre(word);
    		if(!map.containsKey(abreWord))
    			return true;
    		else if(map.containsKey(abreWord) && map.get(abreWord) != null && map.get(abreWord).equals(word))
    			return true;
    		else
    			return false;
    }
    private String abre(String s) {
    		if(s.length() < 3)
    			return s;
    		else {
    			StringBuilder sb = new StringBuilder().append(s.charAt(0)).append((s.length()-2)).append(s.charAt(s.length()-1));
    			return sb.toString();
    		}
    }
}
