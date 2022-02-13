package algoStudy.programmers.bigestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * (Integer.parseInt(o1.toString() + o2.toString())
                        - Integer.parseInt(o2.toString() + o1.toString()));
            }
        });

        if (list.get(0) == 0) {
            return "0";
        }
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        return answer;
    }
}
