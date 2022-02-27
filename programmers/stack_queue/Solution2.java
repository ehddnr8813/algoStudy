package algoStudy.programmers.stack_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 테스트 1 〉 통과 (0.53ms, 77.1MB)
 * 테스트 2 〉 통과 (0.98ms, 75.1MB)
 * 테스트 3 〉 통과 (0.47ms, 77.1MB)
 * 테스트 4 〉 통과 (0.40ms, 77.6MB)
 * 테스트 5 〉 통과 (0.34ms, 73.5MB)
 * 테스트 6 〉 통과 (0.44ms, 72.4MB)
 * 테스트 7 〉 통과 (0.48ms, 73.2MB)
 * 테스트 8 〉 통과 (0.75ms, 64.6MB)
 * 테스트 9 〉 통과 (0.43ms, 76.9MB)
 * 테스트 10 〉 통과 (0.62ms, 71.5MB)
 * 테스트 11 〉 통과 (1.05ms, 77.2MB)
 * 테스트 12 〉 통과 (0.49ms, 73.7MB)
 * 테스트 13 〉 통과 (0.87ms, 77MB)
 * 테스트 14 〉 통과 (0.36ms, 77MB)
 * 테스트 15 〉 통과 (0.46ms, 72.4MB)
 * 테스트 16 〉 통과 (0.56ms, 78MB)
 * 테스트 17 〉 통과 (0.78ms, 70.3MB)
 * 테스트 18 〉 통과 (0.43ms, 81.4MB)
 * 테스트 19 〉 통과 (0.72ms, 73MB)
 * 테스트 20 〉 통과 (0.49ms, 73.3MB)
 * 
 */
public class Solution2 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;

                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[] { 1, 1, 1, 9, 1, 3, 2 }, 5);
    }
}
