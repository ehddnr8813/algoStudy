package algoStudy.programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * 정확성 테스트
 * 테스트 1 〉 통과 (1.70ms, 77.8MB)
 * 테스트 2 〉 통과 (1.50ms, 80.2MB)
 * 테스트 3 〉 통과 (1.58ms, 81.3MB)
 * 테스트 4 〉 통과 (1.43ms, 75.8MB)
 * 테스트 5 〉 통과 (1.53ms, 73.5MB)
 * 테스트 6 〉 통과 (0.44ms, 74.5MB)
 * 테스트 7 〉 통과 (1.37ms, 75MB)
 * 테스트 8 〉 통과 (1.10ms, 79MB)
 * 테스트 9 〉 통과 (0.79ms, 83.5MB)
 * 테스트 10 〉 통과 (1.80ms, 73.9MB)
 * 테스트 11 〉 통과 (0.49ms, 78.9MB)
 * 테스트 12 〉 통과 (0.44ms, 77.2MB)
 * 테스트 13 〉 통과 (0.44ms, 71.9MB)
 * 테스트 14 〉 통과 (0.40ms, 72.2MB)
 * 테스트 15 〉 통과 (0.40ms, 74.5MB)
 * 테스트 16 〉 통과 (0.38ms, 72.6MB)
 * 테스트 17 〉 통과 (0.39ms, 77.3MB)
 * 테스트 18 〉 통과 (0.43ms, 75.6MB)
 * 테스트 19 〉 통과 (0.62ms, 78.1MB)
 * 테스트 20 〉 통과 (0.42ms, 77.9MB)
 */

public class Solution2 {

    class Disk {
        int startTime;
        int duration;

        public Disk(int startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }
    }

    static PriorityQueue<Disk> pq = new PriorityQueue<>(((o1, o2) -> o1.duration - o2.duration));

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));
        // 지금까지 총 걸린시간
        int totalTime = 0;
        // 지금 까지 일이 끝난 disk갯수
        int finished = 0;
        // 현재시간
        int currentTime = 0;
        // queue에 들어간, 시작시간이 현재시간보다 이상이여서
        int diskIndex = 0;

        while (finished < jobs.length) {
            while (diskIndex < jobs.length && jobs[diskIndex][0] <= currentTime) {
                pq.add(new Disk(jobs[diskIndex][0], jobs[diskIndex][1]));
                diskIndex++;
            }

            if (pq.isEmpty()) {
                currentTime = jobs[diskIndex][0];
            } else {
                Disk disk = pq.poll();
                totalTime += currentTime + disk.duration - disk.startTime;
                currentTime += disk.duration;
                finished++;
            }
        }

        return totalTime / jobs.length;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int b = (int) 1.523f;
        System.out.println(b);

        System.out.println(s.solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
    }

}
