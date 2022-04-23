package algoStudy.programmers.dp;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.08ms, 66.8MB)
 * 테스트 2 〉 통과 (0.19ms, 87.3MB)
 * 테스트 3 〉 통과 (0.16ms, 82.2MB)
 * 테스트 4 〉 통과 (0.03ms, 73.3MB)
 * 테스트 5 〉 통과 (0.10ms, 66.8MB)
 * 테스트 6 〉 통과 (0.19ms, 73.7MB)
 * 테스트 7 〉 통과 (0.10ms, 68.6MB)
 * 테스트 8 〉 통과 (0.07ms, 75.8MB)
 * 테스트 9 〉 통과 (0.18ms, 76.9MB)
 * 테스트 10 〉 통과 (0.07ms, 76.9MB)
 */

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.08ms, 66.8MB)
 * 테스트 2 〉 통과 (0.19ms, 87.3MB)
 * 테스트 3 〉 통과 (0.16ms, 82.2MB)
 * 테스트 4 〉 통과 (0.03ms, 73.3MB)
 * 테스트 5 〉 통과 (0.10ms, 66.8MB)
 * 테스트 6 〉 통과 (0.19ms, 73.7MB)
 * 테스트 7 〉 통과 (0.10ms, 68.6MB)
 * 테스트 8 〉 통과 (0.07ms, 75.8MB)
 * 테스트 9 〉 통과 (0.18ms, 76.9MB)
 * 테스트 10 〉 통과 (0.07ms, 76.9MB)
 * 효율성 테스트
 * 테스트 1 〉 통과 (23.59ms, 103MB)
 * 테스트 2 〉 통과 (22.92ms, 102MB)
 * 테스트 3 〉 통과 (23.04ms, 103MB)
 * 테스트 4 〉 통과 (23.17ms, 103MB)
 * 테스트 5 〉 통과 (22.26ms, 98.4MB)
 * 테스트 6 〉 통과 (22.84ms, 102MB)
 * 테스트 7 〉 통과 (20.48ms, 76.1MB)
 * 테스트 8 〉 통과 (20.29ms, 89.7MB)
 * 테스트 9 〉 통과 (21.16ms, 93.8MB)
 * 테스트 10 〉 통과 (24.02ms, 102MB)
 */
public class Solution4 {

    static int dp1[], dp2[];

    public int solution(int[] money) {
        int answer = 0;
        dp1 = new int[money.length];
        dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            answer = Math.max(dp2[i], answer);

            if (i == money.length - 1)
                break;
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            answer = Math.max(answer, dp1[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.solution(new int[] { 1, 2, 3, 1 }));
        System.out.println(s.solution(new int[] { 1, 2, 6 }));
        System.out.println(s.solution(new int[] { 12, 2, 6, 3, 4, 5, 5, 77 }));
    }
}
