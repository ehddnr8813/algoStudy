package algoStudy.acmp.acmp1695;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    static int[] pellin;

    static int dfs(int start, int end) {
        if (dp[start][end] != -1)
            return dp[start][end];
        if (start == end) {
            return 0;
        } else if (start + 1 == end) {
            if (pellin[start] == pellin[end])
                return 0;
            return 1;
        }

        if (pellin[start] == pellin[end]) {
            return dp[start][end] = dfs(start + 1, end - 1);
        } else {
            return dp[start][end] = Math.min(dfs(start, end - 1), dfs(start + 1, end)) + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        pellin = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            pellin[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dfs(0, N - 1));
    }

}
