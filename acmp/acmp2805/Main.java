package algoStudy.acmp.acmp2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int tree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = Integer.MIN_VALUE;
        int mid = 0;
        long total = 0;
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            right = right > tree[i] ? right : tree[i];
        }

        while (left < right) {
            total = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid)
                    total += tree[i] - mid;

            }

            if (total >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);
    }
}
