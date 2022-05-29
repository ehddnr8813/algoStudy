package algoStudy.programmers.graph.ranking;

/**
 * 테스트 1 〉 통과 (0.04ms, 75.9MB)
 * 테스트 2 〉 통과 (0.03ms, 72.8MB)
 * 테스트 3 〉 통과 (0.06ms, 72.8MB)
 * 테스트 4 〉 통과 (0.35ms, 80.1MB)
 * 테스트 5 〉 통과 (0.78ms, 72.7MB)
 * 테스트 6 〉 통과 (2.15ms, 80.1MB)
 * 테스트 7 〉 통과 (6.20ms, 79.4MB)
 * 테스트 8 〉 통과 (7.83ms, 75.6MB)
 * 테스트 9 〉 통과 (15.62ms, 85.9MB)
 * 테스트 10 〉 통과 (12.05ms, 86.4MB)
 */
public class Solution {

    static int graph[][];

    public int solution(int n, int[][] results) {
        graph = new int[n + 1][n + 1];
        int answer = 0;

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int z = 1; z <= n; z++) {
                    if (graph[j][i] == 1 && graph[i][z] == 1)
                        graph[j][z] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                if (graph[i][j] == 1 || graph[j][i] == 1)
                    count++;
            }
            if (count == n - 1)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
    }
}
