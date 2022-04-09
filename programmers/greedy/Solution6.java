package algoStudy.programmers.greedy;

import java.util.Arrays;

/**
 * 
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.49ms, 77.2MB)
 * 테스트 2 〉 통과 (0.50ms, 74.7MB)
 * 테스트 3 〉 통과 (0.50ms, 73.9MB)
 * 테스트 4 〉 통과 (0.48ms, 74.5MB)
 * 테스트 5 〉 통과 (0.53ms, 73.3MB)
 * 효율성 테스트
 * 테스트 1 〉 통과 (5.19ms, 53MB)
 * 테스트 2 〉 통과 (3.29ms, 53.3MB)
 * 테스트 3 〉 통과 (6.75ms, 53.7MB)
 * 테스트 4 〉 통과 (3.65ms, 52MB)
 * 테스트 5 〉 통과 (8.51ms, 53.5MB)
 */
public class Solution6 {

    public int solution(int[][] routes) {
        int lastIndex = -30001;
        int answer = 0;

        Arrays.sort(routes, ((o1, o2) -> o1[1] - o2[1]));
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][1] > lastIndex && routes[i][0] > lastIndex) {
                lastIndex = routes[i][1];
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        s.solution(new int[][] { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } });
    }
}
