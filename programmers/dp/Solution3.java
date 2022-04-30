package algoStudy.programmers.dp;

import java.util.Arrays;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.03ms, 71.6MB)
 * 테스트 2 〉 통과 (0.03ms, 77.7MB)
 * 테스트 3 〉 통과 (0.02ms, 77.5MB)
 * 테스트 4 〉 통과 (0.04ms, 75.3MB)
 * 테스트 5 〉 통과 (0.04ms, 73.8MB)
 * 테스트 6 〉 통과 (0.03ms, 72.5MB)
 * 테스트 7 〉 통과 (0.05ms, 82.2MB)
 * 테스트 8 〉 통과 (0.08ms, 77MB)
 * 테스트 9 〉 통과 (0.04ms, 76MB)
 * 테스트 10 〉 통과 (0.04ms, 85.8MB)
 * 
 */

/**
 * 
 * 효율성 테스트
 * 테스트 1 〉 통과 (0.98ms, 52.3MB)
 * 테스트 2 〉 통과 (0.58ms, 52.4MB)
 * 테스트 3 〉 통과 (0.45ms, 51.7MB)
 * 테스트 4 〉 통과 (1.11ms, 52.2MB)
 * 테스트 5 〉 통과 (0.84ms, 52.2MB)
 * 테스트 6 〉 통과 (0.85ms, 52.6MB)
 * 테스트 7 〉 통과 (0.71ms, 52MB)
 * 테스트 8 〉 통과 (1.09ms, 52.2MB)
 * 테스트 9 〉 통과 (1.03ms, 52.5MB)
 * 테스트 10 〉 통과 (1.17ms, 51.8MB)
 */
public class Solution3 {

    static int dp[][];

    public int solution(int m, int n, int[][] puddles) {

        dp = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1)
                    continue;
                if (i >= 1 && dp[i - 1][j] != -1)
                    dp[i][j] += dp[i - 1][j];
                if (j >= 1 && dp[i][j - 1] != -1)
                    dp[i][j] += dp[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        // System.out.println(dp[99][99]);
        return dp[n - 1][m - 1] % 1000000007;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        // System.out.println(s.solution(4, 3, new int[][] { { 2, 2 } }));
        // System.out.println(s.solution(3, 3, new int[][] { { 1, 3 }, { 3, 1 }, { 2, 3
        // }, { 2, 1 } }));
        System.out.println(s.solution(100, 100,
                new int[][] { { 2, 1 }, { 2, 2 }, { 2, 3 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, { 6, 2 }, { 6, 3 } }));
    }
}
