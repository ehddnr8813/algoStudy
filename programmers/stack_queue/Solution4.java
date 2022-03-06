package algoStudy.programmers.stack_queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.04ms, 77.8MB)
 * 테스트 2 〉 통과 (0.34ms, 80.4MB)
 * 테스트 3 〉 통과 (0.89ms, 74.4MB)
 * 테스트 4 〉 통과 (1.18ms, 78.3MB)
 * 테스트 5 〉 통과 (1.69ms, 78.1MB)
 * 테스트 6 〉 통과 (0.12ms, 77.4MB)
 * 테스트 7 〉 통과 (0.73ms, 77.6MB)
 * 테스트 8 〉 통과 (0.99ms, 79.3MB)
 * 테스트 9 〉 통과 (0.12ms, 76.2MB)
 * 테스트 10 〉 통과 (1.16ms, 73.8MB)
 * 
 * 효율성 테스트
 * 테스트 1 〉 통과 (38.96ms, 73.3MB)
 * 테스트 2 〉 통과 (42.54ms, 69.6MB)
 * 테스트 3 〉 통과 (47.19ms, 74.8MB)
 * 테스트 4 〉 통과 (35.03ms, 71MB)
 * 테스트 5 〉 통과 (35.06ms, 67.1MB)
 */

class Solution4 {

    static Stack<Integer> st = new Stack<>();

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            answer[st.peek()] = prices.length - 1 - st.peek();
            st.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int answer[] = solution(new int[] { 1, 2, 3, 2, 3 });
        System.out.println(Arrays.toString(answer));
    }
}