package algoStudy.acmp.acmp1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V, from, to;
    static int[] node;
    static boolean[] visited;

    static int[][] adj;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adj[from][to] = 1;
            adj[to][from] = 1;
        }
        System.out.print(V + " ");
        visited[V] = true;
        dfs(V);

        System.out.println();
        visited = new boolean[N + 1];
        visited[V] = true;
        System.out.print(V + " ");
        q.add(V);
        bfs();
    }

    static void dfs(int node) {
        for (int i = 1; i <= N; i++) {
            if (adj[node][i] != 0 && !visited[i]) {
                System.out.print(i + " ");
                visited[i] = true;
                dfs(i);
            }
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[n][i] != 0 && !visited[i]) {
                    System.out.print(i + " ");
                    visited[i] = true;
                    q.add(i);
                }
            }

        }
    }
}
