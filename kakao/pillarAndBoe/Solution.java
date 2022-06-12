package algoStudy.kakao.pillarAndBoe;

import java.util.ArrayList;

/**
 * 테스트 1 〉 통과 (0.07ms, 77MB)
 * 테스트 2 〉 통과 (0.08ms, 75.2MB)
 * 테스트 3 〉 통과 (0.06ms, 70.7MB)
 * 테스트 4 〉 통과 (0.06ms, 71.4MB)
 * 테스트 5 〉 통과 (0.06ms, 72.4MB)
 * 테스트 6 〉 통과 (0.10ms, 76.1MB)
 * 테스트 7 〉 통과 (0.08ms, 79MB)
 * 테스트 8 〉 통과 (0.05ms, 77.9MB)
 * 테스트 9 〉 통과 (0.06ms, 72.9MB)
 * 테스트 10 〉 통과 (3.18ms, 77.4MB)
 * 테스트 11 〉 통과 (6.56ms, 82.7MB)
 * 테스트 12 〉 통과 (5.94ms, 80MB)
 * 테스트 13 〉 통과 (10.72ms, 85.1MB)
 * 테스트 14 〉 통과 (2.99ms, 80.1MB)
 * 테스트 15 〉 통과 (3.83ms, 82MB)
 * 테스트 16 〉 통과 (6.31ms, 75.6MB)
 * 테스트 17 〉 통과 (9.84ms, 85.8MB)
 * 테스트 18 〉 통과 (19.22ms, 85.1MB)
 * 테스트 19 〉 통과 (20.04ms, 86.4MB)
 * 테스트 20 〉 통과 (13.04ms, 85.6MB)
 * 테스트 21 〉 통과 (26.46ms, 84.3MB)
 * 테스트 22 〉 통과 (16.48ms, 81.2MB)
 * 테스트 23 〉 통과 (17.60ms, 84.9MB)
 */
public class Solution {

    private boolean pillars[][];
    private boolean boe[][];

    public int[][] solution(int n, int[][] build_frame) {
        pillars = new boolean[n + 3][n + 3];
        boe = new boolean[n + 3][n + 3];
        for (int[] commands : build_frame) {
            int x = commands[0] + 1;
            int y = commands[1] + 1;
            int type = commands[2];
            boolean isDelete = commands[3] == 0 ? true : false;
            if (isDelete) {
                if (type == 0) {
                    pillars[x][y] = false;
                } else {
                    boe[x][y] = false;
                }
                if (!canDestroy(x, y, n)) {
                    if (type == 0) {
                        pillars[x][y] = true;
                    } else {
                        boe[x][y] = true;
                    }
                }
            } else {
                if (type == 0 && checkPillar(x, y)) {
                    pillars[x][y] = true;
                }
                if (type == 1 && checkBoe(x, y)) {
                    boe[x][y] = true;
                }
            }
        }

        ArrayList<int[]> results = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (pillars[i][j])
                    results.add(new int[] { i - 1, j - 1, 0 });
                if (boe[i][j])
                    results.add(new int[] { i - 1, j - 1, 1 });
            }
        }

        int[][] answer = results.toArray(new int[0][0]);
        return answer;
    }

    private boolean checkPillar(int x, int y) {
        return y == 1 || pillars[x][y - 1] || boe[x][y] || boe[x - 1][y];
    }

    private boolean checkBoe(int x, int y) {
        return pillars[x][y - 1] || pillars[x + 1][y - 1] || (boe[x + 1][y] && boe[x - 1][y]);
    }

    private boolean canDestroy(int x, int y, int n) {
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (pillars[i][j] && !checkPillar(i, j))
                    return false;
                if (boe[i][j] && !checkBoe(i, j))
                    return false;
            }
        }
        return true;
    }
}
