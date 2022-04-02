package algoStudy.programmers.greedy;

import java.util.Arrays;

/**
 * 
 * 테스트 1 〉 통과 (0.46ms, 73.9MB)
 * 테스트 2 〉 통과 (0.63ms, 73.7MB)
 * 테스트 3 〉 통과 (0.66ms, 70.6MB)
 * 테스트 4 〉 통과 (0.67ms, 76.1MB)
 * 테스트 5 〉 통과 (0.51ms, 73.5MB)
 * 테스트 6 〉 통과 (0.68ms, 77.3MB)
 * 테스트 7 〉 통과 (0.63ms, 72MB)
 * 테스트 8 〉 통과 (0.58ms, 75.3MB)
 */
public class Solution5 {

    static int[] parent;
    static int finalCost;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                finalCost += costs[i][2];
            }
        }
        return finalCost;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(
                s.solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
    }
}
