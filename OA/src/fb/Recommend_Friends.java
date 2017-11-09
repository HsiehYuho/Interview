package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recommend_Friends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recommend_Friends sol = new Recommend_Friends();
		sol.exe();

	}
	private void exe() {
		Person a = new Person(10);
		getRecommendFriend(a, 10);
	}
	private List<Integer> getRecommendFriend(Person a, int k){
		HashMap<Integer,Integer> map = new HashMap<>(); // count the friend id mutual friend
		List<Person> friends = a.friends;
		int mostCommon = 0;
		for(Person p : friends) {
			for(Person stranger : p.friends) {
				int id = stranger.id;
				map.put(id, map.getOrDefault(id, 0)+1);
				mostCommon = Math.max(map.get(id), mostCommon);
			}
		}
		List<List<Integer>> list = new ArrayList<>(mostCommon); 
		for(int key : map.keySet()) {
			list.get(map.get(key)).add(key);
		}
		List<Integer> recommendation = new ArrayList<>();
		int idx = list.size()-1;
		while(k > 0 && idx >= 0) {
			List<Integer> ids = list.get(idx--);
			for(int tmpid : ids) {
				if(tmpid != a.id && !friends.contains(tmpid)) {
					recommendation.add(tmpid);
					k--;
				}
			}
		}
		return recommendation;
	}
	
	
	
	private class Person{
		int id;
		List<Person> friends;
		public Person(int id) {
			this.id = id;
		}
	}

}
