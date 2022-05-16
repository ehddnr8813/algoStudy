package algoStudy.acmp.acmp2110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0] + 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (!makeNet(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    static boolean makeNet(int diff) {
        int count = 0;
        int before = arr[0];
        for (int i = 1; i < N; i++) {
            int cur = arr[i];
            if (cur - before >= diff) {
                count++;
                before = cur;
                if (count == C + 1)
                    return true;
            }

            if (C - count > N - i)
                return false;
        }
        return true;
    }
}
