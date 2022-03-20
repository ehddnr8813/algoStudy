package algoStudy.programmers.greedy;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        boolean[] visitedLost = new boolean[lost.length];
        boolean[] visitedReserve = new boolean[reserve.length];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    visitedLost[i] = true;
                    visitedReserve[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (visitedLost[i])
                continue;

            for (int j = 0; j < reserve.length; j++) {
                if (visitedReserve[j])
                    continue;
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    visitedLost[i] = true;
                    visitedReserve[j] = true;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
        // System.out.println(s.solution(5, new int[] { 2, 4 }, new int[] { 3 }));
        System.out.println(s.solution(3, new int[] { 3 }, new int[] { 1 }));
    }
}
