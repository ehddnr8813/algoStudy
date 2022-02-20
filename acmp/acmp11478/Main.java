package algoStudy.acmp.acmp11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 메모리 : 231856KB
 * 시간 : 920ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            hm.put(sb.toString(), 0);
            for (int j = i + 1; j < s.length(); j++) {

                sb.append(s.charAt(j));
                hm.put(sb.toString(), 0);

            }
        }
        System.out.println(hm.size());
    }
}
