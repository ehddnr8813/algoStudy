package algoStudy.kakao.string_compress;

public class Solution {

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();

            int repeated = 0;
            String substring = s.substring(0, i);

            for (int j = 0; j <= s.length(); j += i) {
                int start = j;
                int end = Math.min(i + j, s.length());

                String temp = s.substring(start, end);
                if (temp.equals(substring)) {
                    repeated++;
                } else {
                    if (repeated > 1) {
                        sb.append(repeated);
                    }
                    sb.append(substring);

                    substring = temp;
                    repeated = 1;
                }
            }

            if (repeated > 1) {
                sb.append(repeated);
            }

            sb.append(substring);
            answer = Math.min(answer, sb.length());

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("abababdedw");
        s.solution("bedawwwawwwde");
    }

}
