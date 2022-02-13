package algoStudy.poketmonMaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 메모리 : 103792KB
 * 시간 : 832ms
 * 
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameToIndex = new HashMap<>();
        HashMap<Integer, String> indexToName = new HashMap<>();
        String sb = new String();

        for (int i = 1; i < n + 1; i++) {
            String poketmon = br.readLine();
            nameToIndex.put(poketmon, i);
            indexToName.put(i, poketmon);
        }

        while (m-- > 0) {
            String input = br.readLine();
            if (isInteger(input)) {
                sb += indexToName.get(Integer.parseInt(input));
            } else {
                sb += nameToIndex.get(input);
            }
            sb += "\n";
        }

        System.out.println(sb.toString());

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
