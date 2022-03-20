package algoStudy.programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 테스트 1 〉 통과 (0.40ms, 69.2MB)
 * 테스트 2 〉 통과 (0.56ms, 82.9MB)
 * 테스트 3 〉 통과 (0.62ms, 72.4MB)
 * 테스트 4 〉 통과 (0.37ms, 73.8MB)
 * 테스트 5 〉 통과 (0.47ms, 73.2MB)
 * 테스트 6 〉 통과 (0.53ms, 81.8MB)
 * 테스트 7 〉 통과 (0.51ms, 83.3MB)
 * 테스트 8 〉 통과 (0.43ms, 70.8MB)
 * 테스트 9 〉 통과 (3.07ms, 71.1MB)
 * 테스트 10 〉 통과 (0.90ms, 77.1MB)
 * 테스트 11 〉 통과 (0.48ms, 64.3MB)
 * 테스트 12 〉 통과 (0.41ms, 77.9MB)
 * 테스트 13 〉 통과 (0.56ms, 77.6MB)
 * 테스트 14 〉 통과 (0.97ms, 86.6MB)
 * 테스트 15 〉 통과 (0.53ms, 82MB)
 * 테스트 16 〉 통과 (0.47ms, 71.3MB)
 * 테스트 17 〉 통과 (0.54ms, 73.5MB)
 * 테스트 18 〉 통과 (0.37ms, 73.8MB)
 * 테스트 19 〉 통과 (0.51ms, 73MB)
 * 테스트 20 〉 통과 (0.39ms, 65.1MB)
 */
public class Solution3 {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (String s : operations) {
            String[] splited = s.split(" ");

            String first = splited[0];
            int second = Integer.parseInt(splited[1]);

            if (first.equals("I")) {
                pq.offer(second);
                reversePq.offer(second);
            } else {
                if (pq.isEmpty())
                    continue;
                if (second == -1) {
                    reversePq.remove(pq.poll());
                } else {
                    pq.remove(reversePq.poll());
                }
            }
        }

        if (!pq.isEmpty()) {
            answer[0] = reversePq.peek();
            answer[1] = pq.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] arr = new String[] { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.solution(arr)));
    }

}
