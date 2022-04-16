package algoStudy.programmers.dp;

/**
 * 정확성
 * 테스트 1 〉 통과 (0.03ms, 77MB)
 * 테스트 2 〉 통과 (0.03ms, 73.1MB)
 * 테스트 3 〉 통과 (0.04ms, 83.1MB)
 * 테스트 4 〉 통과 (0.08ms, 79.5MB)
 * 테스트 5 〉 통과 (0.23ms, 78.6MB)
 * 테스트 6 〉 통과 (0.11ms, 76.4MB)
 * 테스트 7 〉 통과 (0.20ms, 75.5MB)
 * 테스트 8 〉 통과 (0.10ms, 75.4MB)
 * 테스트 9 〉 통과 (0.02ms, 73.8MB)
 * 테스트 10 〉 통과 (0.05ms, 78.9MB)
 * 
 * 효율성
 * 테스트 1 〉 통과 (7.64ms, 61MB)
 * 테스트 2 〉 통과 (5.30ms, 60MB)
 * 테스트 3 〉 통과 (6.23ms, 62MB)
 * 테스트 4 〉 통과 (5.09ms, 58.4MB)
 * 테스트 5 〉 통과 (5.79ms, 57.9MB)
 * 테스트 6 〉 통과 (6.22ms, 61.7MB)
 * 테스트 7 〉 통과 (6.47ms, 60.6MB)
 * 테스트 8 〉 통과 (5.64ms, 59.6MB)
 * 테스트 9 〉 통과 (7.03ms, 66.8MB)
 * 테스트 10 〉 통과 (11.82ms, 64.5MB)
 */

class Solution2 {

    public int dp[][] = new int[500][500];

    public int solution(int[][] triangle) {
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        int answer = dp[triangle.length - 1][0];
        // for (int i = 0; i < triangle.length; i++) {
        // for (int j = 0; j <= i; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        for (int i = 1; i < triangle.length; i++) {
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));
    }
}