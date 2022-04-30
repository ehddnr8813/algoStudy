package algoStudy.programmers.binarySearch;

import java.util.Arrays;

/**
 * 
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.50ms, 70.9MB)
 * 테스트 2 〉 통과 (0.41ms, 68.8MB)
 * 테스트 3 〉 통과 (0.46ms, 77.4MB)
 * 테스트 4 〉 통과 (4.71ms, 76.1MB)
 * 테스트 5 〉 통과 (4.18ms, 79MB)
 * 테스트 6 〉 통과 (24.54ms, 85.4MB)
 * 테스트 7 〉 통과 (27.23ms, 90.3MB)
 * 테스트 8 〉 통과 (44.77ms, 92.8MB)
 * 테스트 9 〉 통과 (0.31ms, 74.1MB)
 */

public class Solution2 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int left = 0;
        int right = distance;
        int mid = 0;

        Arrays.sort(rocks);

        while (left <= right) {
            mid = (left + right) / 2;

            int removeCnt = 0;
            int currentIdx = 0;

            for (int rock : rocks) {
                if (rock - currentIdx < mid)
                    removeCnt++;
                else
                    currentIdx = rock;
            }

            if (distance - currentIdx < mid)
                removeCnt++;

            if (removeCnt <= n) {
                left = mid + 1;
                answer = mid;
            } else
                right = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(25, new int[] { 2, 14, 11, 21, 17 }, 2));
    }
}
