package algoStudy.programmers.graph.farthestNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 정확성
 * 
 * 테스트 1 〉 통과 (0.44ms, 73.3MB)
 * 테스트 2 〉 통과 (0.30ms, 72.9MB)
 * 테스트 3 〉 통과 (0.40ms, 74.8MB)
 * 테스트 4 〉 통과 (1.08ms, 81.8MB)
 * 테스트 5 〉 통과 (2.11ms, 80.5MB)
 * 테스트 6 〉 통과 (5.41ms, 81.8MB)
 * 테스트 7 〉 통과 (26.61ms, 98.4MB)
 * 테스트 8 〉 통과 (43.00ms, 115MB)
 * 테스트 9 〉 통과 (50.78ms, 113MB)
 * 
 */
class Solution {

    static ArrayList<Integer> graph[];
    static int visited[];
    static int farthest;

    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }

        visited[1] = 1;
        bfs(1, 0);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (farthest == visited[i])
                answer++;
        }
        return answer;
    }

    public void bfs(int start, int cost) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, cost));

        while (!q.isEmpty()) {
            Node from = q.poll();
            farthest = farthest > from.cost ? farthest : from.cost;

            for (int i = 0; i < graph[from.point].size(); i++) {
                int to = graph[from.point].get(i);
                if (visited[to] != 0)
                    continue;

                visited[to] = from.cost + 1;
                q.add(new Node(to, from.cost + 1));
            }
        }
    }

    class Node {
        int point;
        int cost;

        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } });
    }
}