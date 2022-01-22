package algoStudy.unfinishedRunner;

import java.util.HashMap;
import java.util.LinkedList;

class Solution {

	String answer = "";
	HashMap<String, Integer> hm = new HashMap<>();

	public String solution(String[] participant, String[] completion) {
		for (String p : participant)
			hm.put(p, hm.getOrDefault(p, 0) + 1);
		for (String p : completion)
			hm.put(p, hm.get(p) - 1);
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0)
				return key;
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println("hello world");
	}
}