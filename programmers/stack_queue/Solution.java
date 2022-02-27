package algoStudy.programmers.stack_queue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 테스트 1 〉 통과 (0.04ms, 72.8MB)
 * 테스트 2 〉 통과 (0.24ms, 77.7MB)
 * 테스트 3 〉 통과 (0.12ms, 81.7MB)
 * 테스트 4 〉 통과 (0.10ms, 76.6MB)
 * 테스트 5 〉 통과 (0.04ms, 74.4MB)
 * 테스트 6 〉 통과 (0.06ms, 80.2MB)
 * 테스트 7 〉 통과 (0.11ms, 76.8MB)
 * 테스트 8 〉 통과 (0.05ms, 73.8MB)
 * 테스트 9 〉 통과 (0.11ms, 74.9MB)
 * 테스트 10 〉 통과 (0.13ms, 75.8MB)
 * 테스트 11 〉 통과 (0.03ms, 73.9MB)
 * 
 */

public class Solution {
    static Stack<Integer> st = new Stack<>();
    static ArrayList<Integer> ansList = new ArrayList<>();

    static public int[] solution(int[] progresses, int[] speeds) {
        for (int i = progresses.length - 1; i >= 0; i--) {
            st.push((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }
        while (!st.isEmpty()) {
            int count = 1;
            int top = st.pop();

            while (!st.isEmpty() && st.peek() <= top) {
                count++;
                st.pop();
            }
            ansList.add(count);
        }

        int[] answer = new int[ansList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });
    }
}
