package algoStudy.programmers.greedy;

public class Solution2 {
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
