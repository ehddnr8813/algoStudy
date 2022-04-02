package algoStudy.programmers.greedy;

/**
 * 
    정확성
    테스트 1 〉	통과 (1.30ms, 78.7MB)
    테스트 2 〉	통과 (0.85ms, 77.1MB)
    테스트 3 〉	통과 (1.39ms, 74.2MB)
    테스트 4 〉	통과 (1.17ms, 74.6MB)
    테스트 5 〉	통과 (0.84ms, 72.8MB)
    테스트 6 〉	통과 (0.63ms, 77.4MB)
    테스트 7 〉	통과 (0.69ms, 77.2MB)
    테스트 8 〉	통과 (0.36ms, 72.2MB)
    테스트 9 〉	통과 (0.40ms, 73.9MB)
    테스트 10 〉	통과 (1.07ms, 69.5MB)
    테스트 11 〉	통과 (1.14ms, 73.5MB)
    테스트 12 〉	통과 (1.02ms, 74.5MB)
    테스트 13 〉	통과 (1.22ms, 76.8MB)
    테스트 14 〉	통과 (0.89ms, 75.2MB)
    테스트 15 〉	통과 (0.39ms, 75.5MB)

    효율성
    테스트 1 〉	통과 (14.98ms, 62.8MB)
    테스트 2 〉	통과 (8.89ms, 53.6MB)
    테스트 3 〉	통과 (9.98ms, 56.2MB)
    테스트 4 〉	통과 (13.10ms, 73.1MB)
    테스트 5 〉	통과 (9.84ms, 53.8MB)
 */

import java.util.Arrays;

public class Solution4 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int minCount = 0;
        int answer = 0;
        for (int i = people.length - 1; i >= minCount; i--) {
            if (people[i] + people[minCount] <= limit) {
                minCount++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.solution(new int[] { 70, 50, 80, 50 }, 100));
    }
}
