package algoStudy.acmp.acmp2632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int arr[], arr2[];
    static int target, M, N;
    static int aCount[], bCount[];
    static Map<Integer, Integer> bPizza = new HashMap<>();
    static ArrayList<Integer> aKeys = new ArrayList<>();
    static ArrayList<Integer> bKeys = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M];
        arr2 = new int[N];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        int aTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            aTotal += arr[i];
        }

        int bTotal = 0;
        for (int i = 0; i < arr2.length; i++) {
            bTotal += arr2[i];
        }

        aCount = new int[Math.max(aTotal, target) + 1];
        bCount = new int[Math.max(bTotal, target) + 1];

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < i + arr.length - 1; j++) {
                temp += arr[j % arr.length];
                aCount[temp]++;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            int temp = 0;
            for (int j = i; j < i + arr2.length - 1; j++) {
                temp += arr2[j % arr2.length];
                bCount[temp]++;
            }
        }
        aCount[aTotal] = 1;
        bCount[bTotal] = 1;
        aCount[0] = 1;
        bCount[0] = 1;

        int answer = 0;
        for (int i = 0; i <= target; i++) {
            answer += aCount[i] * bCount[target - i];
        }
        System.out.println(answer);
    }
}
