package algoStudy.unfinishedRunner;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 채점 결과
 * 정확성: 50.0
 * 효율성: 50.0
 * 합계: 100.0 / 100.0
 * 
 * 
 */

/**
 * 정확성
 * 
 * 테스트 1 〉 통과 (0.04ms, 71.4MB)
 * 테스트 2 〉 통과 (0.08ms, 73.4MB)
 * 테스트 3 〉 통과 (0.58ms, 80MB)
 * 테스트 4 〉 통과 (1.06ms, 86.4MB)
 * 테스트 5 〉 통과 (0.62ms, 75.1MB)
 * 
 * 
 * 효율성 테스트
 * 테스트 1 〉 통과 (50.67ms, 82.2MB)
 * 테스트 2 〉 통과 (77.46ms, 87.3MB)
 * 테스트 3 〉 통과 (93.83ms, 110MB)
 * 테스트 4 〉 통과 (102.27ms, 97.2MB)
 * 테스트 5 〉 통과 (84.32ms, 95.8MB)
 * 
 */

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
