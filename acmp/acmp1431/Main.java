package algoStudy.acmp.acmp1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 메모리 : 14264KB
 * 시간 : 132 ms
 */

public class Main {

    static int N;
    static ArrayList<SerialNum> serialArr;
    static SerialNum[] arr;

    public static class SerialNum implements Comparable<SerialNum> {
        String str;
        int len;
        int total;

        public SerialNum(String str) {
            this.str = str;
            this.len = str.length();
            this.total = totalNum(str);
        }

        public int totalNum(String str) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    sum += str.charAt(i) - '0';
            }
            return sum;
        }

        @Override
        public int compareTo(SerialNum o) {

            int diff = this.len - o.len;
            if (diff == 0) {
                diff = this.total - o.total;
                if (diff == 0) {
                    return this.str.compareTo(o.str);
                }
                return diff;
            }
            return diff;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        serialArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            serialArr.add(new SerialNum(br.readLine()));
        }
        Collections.sort(serialArr);
        for (SerialNum s : serialArr) {
            System.out.println(s.str);
        }
    }

}