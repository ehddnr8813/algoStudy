package algoStudy.acmp.acmp2632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int arr[], arr2[];
    static int target, M, N;
    static TreeMap<Integer, Integer> aPizza = new TreeMap<>();
    static TreeMap<Integer, Integer> bPizza = new TreeMap<>();

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

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < i + arr.length - 1; j++) {
                temp += arr[j % arr.length];
                if (temp > target)
                    break;
                aPizza.put(temp, aPizza.getOrDefault(temp, 0) + 1);
            }
        }

        int aTtotal = 0;
        for (int i = 0; i < arr.length; i++) {
            aTtotal += arr[i];
        }
        aPizza.put(aTtotal, 1);

        for (int i = 0; i < arr2.length; i++) {
            int temp = 0;
            for (int j = i; j < i + arr2.length - 1; j++) {
                temp += arr2[j % arr2.length];
                if (temp > target)
                    break;
                bPizza.put(temp, bPizza.getOrDefault(temp, 0) + 1);
            }
        }

        int bTtotal = 0;
        for (int i = 0; i < arr2.length; i++) {
            bTtotal += arr2[i];
        }
        bPizza.put(bTtotal, 1);
        aPizza.put(0, 1);
        bPizza.put(0, 1);
        int answer = 0;

        for (Integer key : aPizza.keySet()) {
            if (bPizza.containsKey(target - key)) {
                answer += aPizza.get(key) * bPizza.get(target - key);
            }
        }

        System.out.println(answer);
    }
}
