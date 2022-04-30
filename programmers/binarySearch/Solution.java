package algoStudy.programmers.binarySearch;

import java.util.Arrays;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.52ms, 72.7MB)
 * 테스트 2 〉 통과 (0.59ms, 94.5MB)
 * 테스트 3 〉 통과 (1.76ms, 72.8MB)
 * 테스트 4 〉 통과 (76.10ms, 100MB)
 * 테스트 5 〉 통과 (79.01ms, 94.8MB)
 * 테스트 6 〉 통과 (69.28ms, 95MB)
 * 테스트 7 〉 통과 (96.97ms, 84MB)
 * 테스트 8 〉 통과 (88.99ms, 99.8MB)
 * 테스트 9 〉 통과 (0.35ms, 76.5MB)
 */

public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = 0;
        long left = 0;
        long right = (long) n * times[times.length - 1];
        long mid = 0;
        long passenger = 0;

        while (left <= right) {
            passenger = 0;
            mid = (left + right) / 2;
            for (long time : times) {
                passenger += mid / time;
            }

            if (passenger < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[] { 7, 10 }));
    }
}
