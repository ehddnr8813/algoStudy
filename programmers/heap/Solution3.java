package algoStudy.programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

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
