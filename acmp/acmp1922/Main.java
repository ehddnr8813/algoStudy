package algoStudy.acmp.acmp1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, from, to, cost, total;
    static int parent[];
    static int graph[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        graph = new int[M + 1][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph[i][0] = from;
            graph[i][1] = to;
            graph[i][2] = cost;
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph, ((o1, o2) -> o1[2] - o2[2]));
        for (int i = 0; i < graph.length; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                total += graph[i][2];
            }
        }

        System.out.println(total);
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

}
