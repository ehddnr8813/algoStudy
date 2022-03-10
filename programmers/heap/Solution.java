package algoStudy.programmers.heap;

import java.util.PriorityQueue;

public class Solution {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        int count = 0;

        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.peek() < K && pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            int k = first + second * 2;
            pq.offer(k);
            count++;
        }

        if (pq.peek() >= K)
            return count;
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
    }
}
