
package algoStudy.programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solutionx {
    public static void main(String[] args) {
        // int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; //9
        // int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {20, 1}}; //7
        int[][] jobs = { { 0, 1 }, { 0, 5 }, { 0, 9 }, { 0, 23 }, { 0, 25 } }; // 6
        // int[][] jobs = {{1, 3}, {1, 9}, {2, 6}}; // 9
        // int[][] jobs = { { 1, 9 }, { 1, 3 }, { 2, 6 } }; // 9
        int answer = solution(jobs);
        System.out.println("answer: " + answer);
    }

    /**
     * @param jobs [[0, 3], [1, 9], [2, 6]]
     * @return 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리할때의 평균 9
     */
    public static int solution(int[][] jobs) {
        int answer = 0;
        // 1. jobs 정렬 및 초기자료구조(jobPQueue) 세팅
        Arrays.sort(jobs, (job1, job2) -> {
            if (job1[0] <= job2[0]) {
                return -1;
            }
            return 1;
            // return job1[0] - job2[0];
        });
        Queue<int[]> jobPQueue = new PriorityQueue<>((job1, job2) -> {
            if (job1[1] <= job2[1]) {
                return -1;
            }
            return 1;
            // return job1[1] - job2[1];
        });
        // 2. answer에 작업시작시간부터 끝날때까지 걸린 시간을 더한다.
        int i = 0;
        int time = 0;
        while (i < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= time) {
                jobPQueue.offer(jobs[i]);
                i++;
            }
            if (jobPQueue.isEmpty()) {
                time = jobs[i][0];
                continue;
            }
            int[] job = jobPQueue.poll();
            time += job[1];
            answer += time - job[0];
        }
        // 3. 평균 구하여 return

        return answer / jobs.length;
    }
}