package algoStudy.programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

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
        int totalTime = 0;
        int finished = 0;
        int currentTime = 0;
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
        System.out.println(s.solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
    }

}
