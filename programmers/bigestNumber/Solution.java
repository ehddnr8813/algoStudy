package algoStudy.programmers.bigestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 테스트 1 〉	통과 (1868.88ms, 390MB)
// 테스트 2 〉	통과 (723.66ms, 396MB)
// 테스트 3 〉	통과 (3215.95ms, 440MB)
// 테스트 4 〉	통과 (43.14ms, 114MB)
// 테스트 5 〉	통과 (1623.79ms, 416MB)
// 테스트 6 〉	통과 (1210.72ms, 416MB)
// 테스트 7 〉	통과 (3.39ms, 75.7MB)
// 테스트 8 〉	통과 (2.15ms, 76.5MB)
// 테스트 9 〉	통과 (2.37ms, 78.6MB)
// 테스트 10 〉	통과 (1.91ms, 78.9MB)
// 테스트 11 〉	통과 (3.48ms, 76.9MB)
// 테스트 12 〉	통과 (2.02ms, 72.7MB)
// 테스트 13 〉	통과 (3.33ms, 78.5MB)
// 테스트 14 〉	통과 (1.88ms, 78.1MB)
// 테스트 15 〉	통과 (1.91ms, 76.8MB)   

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * (Integer.parseInt(o1.toString() + o2.toString())
                        - Integer.parseInt(o2.toString() + o1.toString()));
            }
        });

        if (list.get(0) == 0) {
            return "0";
        }
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
