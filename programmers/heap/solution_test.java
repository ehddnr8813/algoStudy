package algoStudy.programmers.heap;

import java.util.PriorityQueue;

public class solution_test {
    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(((job1, job2) -> {
            if (job1[1] <= job2[1]) {
                return -1;
            }
            return job1[1] - job2[1];
        }));

        int[][] jobs = { { 0, 1 }, { 0, 5 }, { 0, 9 }, { 0, 4 }, { 0, 6 } }; // 6

        for (int i = 0; i < jobs.length; i++) {
            pq.offer(jobs[i]);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()[1]);
        }

    }

}