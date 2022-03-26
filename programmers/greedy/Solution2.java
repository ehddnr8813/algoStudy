package algoStudy.programmers.greedy;

public class Solution2 {
    /**
     * 
     * 테스트 1 〉 통과 (0.07ms, 74.5MB)
     * 테스트 2 〉 통과 (0.03ms, 68.7MB)
     * 테스트 3 〉 통과 (0.03ms, 78.1MB)
     * 테스트 4 〉 통과 (0.04ms, 75.5MB)
     * 테스트 5 〉 통과 (0.03ms, 78.1MB)
     * 테스트 6 〉 통과 (0.05ms, 76.9MB)
     * 테스트 7 〉 통과 (0.03ms, 75.6MB)
     * 테스트 8 〉 통과 (0.04ms, 72.8MB)
     * 테스트 9 〉 통과 (0.08ms, 81.6MB)
     * 테스트 10 〉 통과 (0.04ms, 71.1MB)
     * 테스트 11 〉 통과 (0.04ms, 76.2MB)
     * 테스트 12 〉 통과 (0.04ms, 75.3MB)
     * 테스트 13 〉 통과 (0.04ms, 75.5MB)
     * 테스트 14 〉 통과 (0.04ms, 79MB)
     * 테스트 15 〉 통과 (0.03ms, 75.8MB)
     * 테스트 16 〉 통과 (0.04ms, 74.4MB)
     * 테스트 17 〉 통과 (0.06ms, 72.3MB)
     * 테스트 18 〉 통과 (0.07ms, 73.6MB)
     * 테스트 19 〉 통과 (0.04ms, 74.4MB)
     * 테스트 20 〉 통과 (0.07ms, 75.7MB)
     * 테스트 21 〉 통과 (0.03ms, 73.3MB)
     * 테스트 22 〉 통과 (0.06ms, 72.4MB)
     * 테스트 23 〉 통과 (0.04ms, 76.1MB)
     * 테스트 24 〉 통과 (0.02ms, 72.7MB)
     * 테스트 25 〉 통과 (0.04ms, 75.2MB)
     * 테스트 26 〉 통과 (0.03ms, 75.1MB)
     * 테스트 27 〉 통과 (0.07ms, 81.6MB)
     * 
     * 
     */
    public int solution(String name) {

        int answer = 0;
        int min = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            // 25- x +1 or x
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 'serial A lengths'
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            min = Math.min(min, Math.min(i * 2 + name.length() - next, (name.length() - next) * 2 + i));

        }
        return answer += min;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution("JEROEN"));
        System.out.println(s.solution("ABAAAACAA"));
        System.out.println(s.solution("ABAAAACAAAAAAAAAAAAADAAAAEAAAAAAAAAAAAAAAAAAA"));
    }
}
