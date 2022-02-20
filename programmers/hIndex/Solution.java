package algoStudy.programmers.hIndex;

import java.util.ArrayList;

/**
 * 테스트 1 〉 통과 (1.30ms, 79.6MB)
 * 테스트 2 〉 통과 (1.56ms, 78.7MB)
 * 테스트 3 〉 통과 (1.71ms, 77.3MB)
 * 테스트 4 〉 통과 (1.52ms, 76.4MB)
 * 테스트 5 〉 통과 (2.52ms, 73.6MB)
 * 테스트 6 〉 통과 (1.74ms, 76MB)
 * 테스트 7 〉 통과 (1.52ms, 72.6MB)
 * 테스트 8 〉 통과 (1.00ms, 75.1MB)
 * 테스트 9 〉 통과 (0.87ms, 76.3MB)
 * 테스트 10 〉 통과 (1.17ms, 76.5MB)
 * 테스트 11 〉 통과 (1.85ms, 78.5MB)
 * 테스트 12 〉 통과 (1.22ms, 73.6MB)
 * 테스트 13 〉 통과 (1.60ms, 74.9MB)
 * 테스트 14 〉 통과 (1.68ms, 79.8MB)
 * 테스트 15 〉 통과 (1.80ms, 78.5MB)
 * 테스트 16 〉 통과 (0.46ms, 73.1MB)
 */

public class Solution {
  public static int solution(int[] citations) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < citations.length; i++) {
      list.add(citations[i]);
    }
    list.sort((a1, a2) -> a2.compareTo(a1));

    for (int i = 0; i < list.size(); i++) {
      if (i >= list.get(i)) {
        return i;
      }
    }
    return list.size();
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[] { 1, 23, 3, 7, 5, 6 }));
  }
}
