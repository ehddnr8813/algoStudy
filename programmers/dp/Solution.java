package algoStudy.programmers.dp;

import java.util.HashSet;

public class Solution {

    static HashSet<Integer> dp[] = new HashSet[10];

    public void initSets(int N) {
        int num = 0;
        for (int i = 1; i <= 9; i++) {
            num = num * 10 + N;
            dp[i] = new HashSet<>();
            dp[i].add(num);
        }
    }

    /**
     * 테스트 1 〉 통과 (2.00ms, 80.8MB)
     * 테스트 2 〉 통과 (0.08ms, 74.8MB)
     * 테스트 3 〉 통과 (0.25ms, 81MB)
     * 테스트 4 〉 통과 (38.52ms, 96MB)
     * 테스트 5 〉 통과 (17.02ms, 85.1MB)
     * 테스트 6 〉 통과 (0.68ms, 74.3MB)
     * 테스트 7 〉 통과 (0.61ms, 78.8MB)
     * 테스트 8 〉 통과 (12.14ms, 78.5MB)
     * 테스트 9 〉 통과 (0.05ms, 74.5MB)
     *
     */
    public int solution(int N, int number) {
        initSets(N);
        for (int k = 1; k <= 9; k++) {
            for (int i = 1; i < k; i++) {
                for (int j = 1; j < k; j++) {
                    if (i + j != k)
                        continue;
                    for (Integer a : dp[i]) {
                        for (Integer b : dp[j]) {
                            dp[k].add(a + b);
                            dp[k].add(a * b);
                            if (a > b)
                                dp[k].add(a - b);
                            if (a / b > 0)
                                dp[k].add(a / b);
                        }
                    }
                }
            }

            if (dp[k].contains(number))
                return k;
        }

        return -1;
    }

}