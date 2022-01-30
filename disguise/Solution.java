package algoStudy.disguise;

import java.util.HashMap;

/**
 * 
 * 테스트 1 〉 통과 (0.06ms, 77.8MB)
 * 테스트 2 〉 통과 (0.05ms, 78.2MB)
 * 테스트 3 〉 통과 (0.06ms, 76.6MB)
 * 테스트 4 〉 통과 (0.10ms, 73MB)
 * 테스트 5 〉 통과 (0.06ms, 75.5MB)
 * 테스트 6 〉 통과 (0.05ms, 67.8MB)
 * 테스트 7 〉 통과 (0.06ms, 72.1MB)
 * 테스트 8 〉 통과 (0.06ms, 74.1MB)
 * 테스트 9 〉 통과 (0.04ms, 76MB)
 * 테스트 10 〉 통과 (0.04ms, 76.4MB)
 * 테스트 11 〉 통과 (0.05ms, 76.3MB)
 * 테스트 12 〉 통과 (0.06ms, 77.4MB)
 * 테스트 13 〉 통과 (0.09ms, 73.3MB)
 * 테스트 14 〉 통과 (0.03ms, 79.3MB)
 * 테스트 15 〉 통과 (0.04ms, 73.4MB)
 * 테스트 16 〉 통과 (0.04ms, 82.8MB)
 * 테스트 17 〉 통과 (0.06ms, 74.3MB)
 * 테스트 18 〉 통과 (0.05ms, 74.8MB)
 * 테스트 19 〉 통과 (0.05ms, 74.9MB)
 * 테스트 20 〉 통과 (0.06ms, 72.8MB)
 * 테스트 21 〉 통과 (0.06ms, 78.7MB)
 * 테스트 22 〉 통과 (0.04ms, 74.9MB)
 * 테스트 23 〉 통과 (0.05ms, 73.8MB)
 * 테스트 24 〉 통과 (0.07ms, 74.2MB)
 * 테스트 25 〉 통과 (0.07ms, 73.8MB)
 * 테스트 26 〉 통과 (0.08ms, 78MB)
 * 테스트 27 〉 통과 (0.05ms, 76.8MB)
 * 테스트 28 〉 통과 (0.07ms, 74.4MB)
 */

public class Solution {
    static HashMap<String, Integer> hm = new HashMap<>();

    public static int solution(String[][] clothes) {
        for (String[] s : clothes) {
            hm.put(s[1], hm.getOrDefault(s[1], 0) + 1);
        }
        int count = 1;
        for (String key : hm.keySet()) {
            count *= (hm.get(key) + 1);
        }
        return count - 1;
    }

    public static void main(String[] args) {
        String[][] example = new String[][] { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" } };
        System.out.println(solution(example));
    }
}
