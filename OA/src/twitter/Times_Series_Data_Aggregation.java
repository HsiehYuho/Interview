package twitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Times_Series_Data_Aggregation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Times_Series_Data_Aggregation sol = new Times_Series_Data_Aggregation();
		sol.exe();
	}
	private void exe() {
		String[] date = new String[5];
		date[0]= "2015-12-05, click, 635";
		date[1] = "2014-12-05, add, 350";
		date[2] = "2014-12-05, install, 100 \n";
		date[3] = "2015-12-05, click, 635\n";
		date[4]= "2015-3-05, poke, 635";
		for(int i = 0; i < 5; i++)
			processString(date[i]);
		String[] output = output();
		for(String s : output)
			System.out.println(s);
	
	}	
	private TreeMap<String,Date> dateToTypeCount = new TreeMap<>(new MyDateComp());

	class MyDateComp implements Comparator<String>{
	    @Override
	    public int compare(String a, String b) {
			String[] stra = a.split("-");
			String[] strb = b.split("-");
			if(stra[0].equals(strb[0]))
				return Integer.valueOf(strb[1]) - Integer.valueOf(stra[1]);
			return Integer.valueOf(strb[0]) - Integer.valueOf(stra[0]);
		}
	}
	// 2015-08-15, click, 635
	private void processString(String s) {
		s = s.replaceAll("\r|\n","");  
		s = s.replaceAll(" ", "");
		String[] strs = s.split(",");
		catagorize(strs);
		return;
	}
	private void catagorize(String[] data) { // 2015-08-15,click,100
		String[] completeDate = data[0].split("-"); // 2015, 08, 15
		String date = completeDate[0]+"-"+completeDate[1];
		String type = data[1];
		String count = data[2];
		if(!dateToTypeCount.containsKey(date))
			dateToTypeCount.put(date, new Date(date));
		Date dateObj = dateToTypeCount.get(date);
		dateObj.add(new String[] {type,count});
		return;
	}	
	private String[] output() {
		List<String> res = new ArrayList<>(); 
		for(String date : dateToTypeCount.keySet()) {
			Date obj = dateToTypeCount.get(date);
			res.add(obj.retrieve());
		}
		String[] ans = new String[res.size()];
		for(int i = 0; i < res.size(); i++)
			ans[i] = res.get(i);
		return ans;
	}
	
	private class Date{
		HashMap<String,Integer> styleAndCount;
		String date;
		// input format date = 2017-03
		public Date(String date) {
			styleAndCount = new HashMap<>();
			this.date = date;
		}
		// input format {like,100}
		private void add(String[] data) {
			String type = data[0];
			int count = Integer.valueOf(data[1]);
			styleAndCount.put(type, styleAndCount.getOrDefault(type, 0)+count);
		}
		// handle 2017-12, click, 100, install, 100 case
		private String retrieve() {
			String result = "";
			for(String key : styleAndCount.keySet()) {
				result += key + ", " + styleAndCount.get(key) + ", ";
			}
			return date+", " + result.substring(0, result.length()-2);
		}

		
	}

}
