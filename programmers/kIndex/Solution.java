package algoStudy.programmers.kIndex;

import java.util.Arrays;

/**
 * 테스트 1 〉 통과 (0.33ms, 72.8MB)
 * 테스트 2 〉 통과 (0.36ms, 77.9MB)
 * 테스트 3 〉 통과 (0.50ms, 89.1MB)
 * 테스트 4 〉 통과 (0.46ms, 84.5MB)
 * 테스트 5 〉 통과 (0.38ms, 78.2MB)
 * 테스트 6 〉 통과 (0.34ms, 64.9MB)
 * 테스트 7 〉 통과 (0.33ms, 77.6MB)
 */

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            int[] temp = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(temp);
            answer[idx] = temp[k - 1];
        }
        return answer;
    }
}
