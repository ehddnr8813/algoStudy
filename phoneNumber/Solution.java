package algoStudy.phoneNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {

	static HashMap<String, Integer> hm = new HashMap<>();

	/**
	 * 테스트 1 〉 통과 (0.44ms, 74.4MB)
	 * 테스트 2 〉 통과 (0.20ms, 78.6MB)
	 * 테스트 3 〉 통과 (0.19ms, 74.3MB)
	 * 테스트 4 〉 통과 (0.28ms, 77.7MB)
	 * 테스트 5 〉 통과 (0.28ms, 74.4MB)
	 * 테스트 6 〉 통과 (0.22ms, 73.1MB)
	 * 테스트 7 〉 통과 (0.29ms, 75.2MB)
	 * 테스트 8 〉 통과 (0.23ms, 75.9MB)
	 * 테스트 9 〉 통과 (0.21ms, 74.7MB)
	 * 테스트 10 〉 통과 (0.20ms, 74.9MB)
	 * 테스트 11 〉 통과 (0.31ms, 75MB)
	 * 테스트 12 〉 통과 (0.26ms, 72.3MB)
	 * 테스트 13 〉 통과 (0.19ms, 72.1MB)
	 * 테스트 14 〉 통과 (1.87ms, 74.5MB)
	 * 테스트 15 〉 통과 (2.92ms, 74.9MB)
	 * 테스트 16 〉 통과 (4.25ms, 76.8MB)
	 * 테스트 17 〉 통과 (4.22ms, 65.2MB)
	 * 테스트 18 〉 통과 (5.39ms, 75.8MB)
	 * 테스트 19 〉 통과 (7.28ms, 78.7MB)
	 * 테스트 20 〉 통과 (7.81ms, 72.8MB)
	 * 효율성 테스트
	 * 테스트 1 〉 통과 (16.67ms, 56.2MB)
	 * 테스트 2 〉 통과 (26.08ms, 55.7MB)
	 * 테스트 3 〉 통과 (323.58ms, 97.8MB)
	 * 테스트 4 〉 통과 (284.81ms, 95.2MB)
	 */
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i]))
				return false;
		}
		return true;
	}

	/**
	 * 정확성 테스트
	 * 테스트 1 〉 통과 (9.38ms, 71.3MB)
	 * 테스트 2 〉 통과 (8.99ms, 75.3MB)
	 * 테스트 3 〉 통과 (10.26ms, 84.5MB)
	 * 테스트 4 〉 통과 (9.41ms, 72.5MB)
	 * 테스트 5 〉 통과 (9.18ms, 77.9MB)
	 * 테스트 6 〉 통과 (9.34ms, 68.4MB)
	 * 테스트 7 〉 통과 (9.30ms, 72.5MB)
	 * 테스트 8 〉 통과 (9.62ms, 74.8MB)
	 * 테스트 9 〉 통과 (10.66ms, 75.3MB)
	 * 테스트 10 〉 통과 (14.33ms, 74.2MB)
	 * 테스트 11 〉 통과 (11.69ms, 72.9MB)
	 * 테스트 12 〉 통과 (11.47ms, 70.5MB)
	 * 테스트 13 〉 통과 (9.62ms, 77.7MB)
	 * 테스트 14 〉 통과 (18.99ms, 89.7MB)
	 * 테스트 15 〉 통과 (24.30ms, 84.7MB)
	 * 테스트 16 〉 통과 (23.57ms, 91.3MB)
	 * 테스트 17 〉 통과 (31.42ms, 84.4MB)
	 * 테스트 18 〉 통과 (25.58ms, 80.3MB)
	 * 테스트 19 〉 통과 (23.00ms, 89.5MB)
	 * 테스트 20 〉 통과 (27.88ms, 87.3MB)
	 * 효율성 테스트
	 * 테스트 1 〉 통과 (17.13ms, 58.3MB)
	 * 테스트 2 〉 통과 (29.42ms, 58MB)
	 * 테스트 3 〉 통과 (344.16ms, 224MB)
	 * 테스트 4 〉 통과 (290.36ms, 158MB)
	 */

	public static boolean solution2(String[] phone_book) {
		for (int i = 0; i < phone_book.length; i++) {
			hm.put(phone_book[i], 1);
		}
		for (int i = 0; i < phone_book.length; i++) {
			String temp = "";
			for (int j = 0; j < phone_book[i].length(); j++) {
				temp += phone_book[i].charAt(j);
				if (hm.get(temp) != null && !temp.equals(phone_book[i]))
					return false;
			}

		}
		return true;
	}

	/**
	 * 테스트 1 〉 통과 (0.36ms, 71.4MB)
	 * 테스트 2 〉 통과 (0.50ms, 75.4MB)
	 * 테스트 3 〉 통과 (0.38ms, 74.6MB)
	 * 테스트 4 〉 통과 (0.48ms, 76.7MB)
	 * 테스트 5 〉 통과 (0.51ms, 72.5MB)
	 * 테스트 6 〉 통과 (0.36ms, 73.3MB)
	 * 테스트 7 〉 통과 (0.38ms, 72.5MB)
	 * 테스트 8 〉 통과 (0.63ms, 77.7MB)
	 * 테스트 9 〉 통과 (0.48ms, 76.6MB)
	 * 테스트 10 〉 통과 (0.33ms, 76MB)
	 * 테스트 11 〉 통과 (0.37ms, 73.2MB)
	 * 테스트 12 〉 통과 (0.35ms, 77MB)
	 * 테스트 13 〉 통과 (0.48ms, 79MB)
	 * 테스트 14 〉 통과 (9.44ms, 80.4MB)
	 * 테스트 15 〉 통과 (11.31ms, 79.9MB)
	 * 테스트 16 〉 통과 (14.34ms, 75.2MB)
	 * 테스트 17 〉 통과 (24.47ms, 83.7MB)
	 * 테스트 18 〉 통과 (22.02ms, 84.6MB)
	 * 테스트 19 〉 통과 (21.69ms, 95MB)
	 * 테스트 20 〉 통과 (35.14ms, 78.7MB)
	 * 효율성 테스트
	 * 테스트 1 〉 통과 (11.44ms, 55.7MB)
	 * 테스트 2 〉 통과 (13.40ms, 56.9MB)
	 * 테스트 3 〉 실패 (시간 초과)
	 * 테스트 4 〉 실패 (시간 초과)
	 */

	public static boolean soultion3(String[] phone_book) {

		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(Arrays.toString(phone_book));

		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] testArr = { "12", "123", "1235", "567", "88" };
		System.out.println(soultion3(testArr));
	}
}
