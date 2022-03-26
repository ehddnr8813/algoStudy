package algoStudy.programmers.greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 * 테스트 1 〉 통과 (0.04ms, 76.5MB)
 * 테스트 2 〉 통과 (0.06ms, 73.4MB)
 * 테스트 3 〉 통과 (0.32ms, 75.5MB)
 * 테스트 4 〉 통과 (0.57ms, 77MB)
 * 테스트 5 〉 통과 (1.58ms, 73.1MB)
 * 테스트 6 〉 통과 (14.88ms, 70.9MB)
 * 테스트 7 〉 통과 (27.93ms, 85.2MB)
 * 테스트 8 〉 통과 (121.26ms, 84.5MB)
 * 테스트 9 〉 통과 (5.09ms, 94.5MB)
 * 테스트 10 〉 통과 (3413.85ms, 89.4MB)
 * 테스트 11 〉 통과 (0.06ms, 78.2MB)
 * 테스트 12 〉 통과 (0.04ms, 75.8MB)
 * 
 */

public class Solution3 {

    public String solution(String number, int k) {
        StringBuilder s = new StringBuilder(number);

        while (k != 0) {
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j < i + 1 + k && j < s.length(); j++) {
                    if (s.charAt(i) - '0' < s.charAt(j) - '0') {
                        s.deleteCharAt(i);
                        i -= 1;
                        k--;
                        break;
                    }
                }
                if (k == 0)
                    break;
            }

            s.delete(s.length() - k, s.length());
            break;
        }
        return s.toString();
    }

    /**
     * 테스트 1 〉 통과 (0.23ms, 79.1MB)
     * 테스트 2 〉 통과 (0.24ms, 77.1MB)
     * 테스트 3 〉 통과 (0.33ms, 74.6MB)
     * 테스트 4 〉 통과 (1.13ms, 74.8MB)
     * 테스트 5 〉 통과 (1.05ms, 77.8MB)
     * 테스트 6 〉 통과 (5.30ms, 76.9MB)
     * 테스트 7 〉 통과 (13.59ms, 78.7MB)
     * 테스트 8 〉 통과 (15.05ms, 75.1MB)
     * 테스트 9 〉 통과 (37.17ms, 97.2MB)
     * 테스트 10 〉 통과 (63.15ms, 85.1MB)
     * 테스트 11 〉 통과 (0.25ms, 78.6MB)
     * 테스트 12 〉 통과 (0.30ms, 70.6MB)
     * 
     */

    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        // System.out.println(s.solution("1231234", 3));
        // System.out.println(s.solution("4177252841", 4));
        System.out.println(s.solution("77777777", 5));
        System.out.println(s.solution2("4177252841", 4));
    }
}
