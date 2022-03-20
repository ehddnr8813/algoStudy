package algoStudy.programmers.greedy;

import java.util.Arrays;

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
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        boolean[] visitedLost = new boolean[lost.length];
        boolean[] visitedReserve = new boolean[reserve.length];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    visitedLost[i] = true;
                    visitedReserve[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (visitedLost[i])
                continue;

            for (int j = 0; j < reserve.length; j++) {
                if (visitedReserve[j])
                    continue;
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    visitedLost[i] = true;
                    visitedReserve[j] = true;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
        // System.out.println(s.solution(5, new int[] { 2, 4 }, new int[] { 3 }));
        System.out.println(s.solution(3, new int[] { 3 }, new int[] { 1 }));
    }
}
