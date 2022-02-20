package algoStudy.programmers.bestAlbum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 테스트 1 〉 통과 (0.88ms, 72.6MB)
 * 테스트 2 〉 통과 (0.88ms, 76.7MB)
 * 테스트 3 〉 통과 (0.90ms, 87.2MB)
 * 테스트 4 〉 통과 (0.79ms, 72.3MB)
 * 테스트 5 〉 통과 (1.07ms, 79.4MB)
 * 테스트 6 〉 통과 (1.08ms, 76.8MB)
 * 테스트 7 〉 통과 (0.94ms, 85.2MB)
 * 테스트 8 〉 통과 (0.89ms, 78.8MB)
 * 테스트 9 〉 통과 (0.93ms, 73.5MB)
 * 테스트 10 〉 통과 (1.07ms, 74MB)
 * 테스트 11 〉 통과 (1.12ms, 77.5MB)
 * 테스트 12 〉 통과 (0.90ms, 77.7MB)
 * 테스트 13 〉 통과 (0.94ms, 76.1MB)
 * 테스트 14 〉 통과 (1.32ms, 77.1MB)
 * 테스트 15 〉 통과 (0.85ms, 76.5MB)
 * 
 */

public class Solution {

    /**
     * 1. total 재생 많은 순으로 장르 저장 : key: genre, value: 횟수로 hash에 저장 후 재생 회수로 정렬
     * 2. 장르에서 2개 이하로 골라서 array에 넣기
     * 3. 2개 고를때 정렬 순서: idx가 작은 것, plays가 많은대로 comparable 또는 comparator사용하자
     */
    public static class Music implements Comparable<Music> {
        String gnere;
        int idx;
        int count;

        public Music(String gnere, int idx, int count) {
            this.gnere = gnere;
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Music o) {
            int diff = o.count - this.count;
            if (diff == 0)
                diff = this.idx - o.idx;
            return diff;
        }

    }

    static HashMap<String, Integer> totalCntGenres = new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {

        for (int i = 0; i < genres.length; i++) {
            totalCntGenres.put(genres[i], totalCntGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> soretedGenres = new ArrayList<>(totalCntGenres.keySet());
        Collections.sort(soretedGenres, (v1, v2) -> (totalCntGenres.get(v2).compareTo(totalCntGenres.get(v1))));

        ArrayList<Music> mostPlayed = new ArrayList<>();

        for (String genre : soretedGenres) {
            ArrayList<Music> list = new ArrayList<>();

            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    list.add(new Music(genres[i], i, plays[i]));
                }
            }

            Collections.sort(list);
            mostPlayed.add(list.get(0));
            if (list.size() > 1) {
                mostPlayed.add(list.get(1));
            }
        }

        int[] answer = new int[mostPlayed.size()];
        for (int i = 0; i < mostPlayed.size(); i++) {
            answer[i] = mostPlayed.get(i).idx;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}