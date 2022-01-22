package algoStudy.phoneNumber;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

	static HashMap<String, Integer> hm = new HashMap<>();

	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i]))
				return false;
		}
		return true;
	}

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

	public static void main(String[] args) {
		String[] testArr = { "12", "123", "1235", "567", "88" };
		System.out.println(solution2(testArr));
	}
}
