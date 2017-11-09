package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shoppingCart {
	public static void main(String[] args) {
		shoppingCart a = new shoppingCart();
		a.exe();
	}
	public void exe() {
		List<List<String>> codeList = new ArrayList<>();
		List<String> listA = new ArrayList<>();
		List<String> listB = new ArrayList<>();
		List<String> listC = new ArrayList<>();
		listA.add("a");
		listA.add("b");
		listA.add("c");
		listB.add("d");
		listB.add("d");
		listC.add("d");
		listC.add("e");
		codeList.add(listA);
		codeList.add(listB);
		codeList.add(listC);

		List<String> shopList = new ArrayList<>();
		shopList.add("a");
		shopList.add("d");
		shopList.add("b");
		shopList.add("c");
		shopList.add("d");
		shopList.add("f");
		shopList.add("d");
		System.out.println(checkWinner(codeList,shopList));
		

		return;
	}
	public boolean checkWinner (List<List<String>> codeList, List<String> shoppingCart) {
		int[] idx = new int[codeList.size()+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(idx);
		return compute(q,shoppingCart,codeList);
	}
	private boolean compute(Queue<int[]> q, List<String> shoppingCart, List<List<String>> codeList) {
		while(q.size() != 0) {
			// termination situation
			int[] idx = q.poll();
			for(int i : idx) {
				System.out.print(i + " ");
			}
			System.out.println();
			int shopIdx = idx.length-1;
			int codeLen = idx.length-1;
			int finalIdx = 0;
			for(; finalIdx < codeLen; finalIdx++) {
				if(idx[finalIdx] != codeList.get(finalIdx).size())
					break;
			}
			if(finalIdx == codeLen)
				return true;
			if(idx[shopIdx] == shoppingCart.size())
				continue;;

			// computation
			String candidate = shoppingCart.get(idx[shopIdx]);
			for(int i = 0; i < codeLen; i++) {
				if(idx[i] == codeList.get(i).size())
					continue;
				String code = codeList.get(i).get(idx[i]);
				if(code.equals(candidate) || candidate.equals("Anything")) {
					int[] newIdx = Arrays.copyOf(idx,idx.length);
					newIdx[shopIdx]++;
					newIdx[i]++;
					q.offer(newIdx);
				}
			}
			// if candidate does not equal to any string
			int[] newQ = Arrays.copyOf(idx,idx.length);
			newQ[shopIdx]++;
			q.offer(newQ);
		}
		return false;
	}

}
