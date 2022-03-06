package algoStudy.programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 테스트 1 〉 통과 (1.50ms, 75.1MB)
 * 테스트 2 〉 통과 (8.67ms, 71.7MB)
 * 테스트 3 〉 통과 (0.37ms, 76.8MB)
 * 테스트 4 〉 통과 (17.20ms, 86.5MB)
 * 테스트 5 〉 통과 (39.33ms, 101MB)
 * 테스트 6 〉 통과 (25.54ms, 94.6MB)
 * 테스트 7 〉 통과 (1.53ms, 77.1MB)
 * 테스트 8 〉 통과 (1.11ms, 78.3MB)
 * 테스트 9 〉 통과 (8.08ms, 76.5MB)
 * 테스트 10 〉 통과 (0.85ms, 69.7MB)
 * 테스트 11 〉 통과 (0.40ms, 76.7MB)
 * 테스트 12 〉 통과 (1.26ms, 74.1MB)
 * 테스트 13 〉 통과 (2.23ms, 67.4MB)
 * 테스트 14 〉 통과 (0.21ms, 74.1MB)
 */
class Solution3 {

  class Truck {
    int size;
    int timeLeft;

    Truck(int size, int timeLeft) {
      this.size = size;
      this.timeLeft = timeLeft;
    }
  }

  static Queue<Truck> truckQueue = new LinkedList<>();
  static Queue<Truck> waiting = new LinkedList<>();

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    for (int i = 0; i < truck_weights.length; ++i) {
      waiting.offer(new Truck(truck_weights[i], bridge_length));
    }

    // 7 4 5 6
    int total = waiting.peek().size;
    int answer = 1;
    truckQueue.offer(waiting.poll());

    while (!waiting.isEmpty()) {

      for (Truck t : truckQueue) {
        t.timeLeft -= 1;
      }

      if (truckQueue.peek().timeLeft == 0) {
        Truck t = truckQueue.poll();
        total -= t.size;
      }

      if (truckQueue.size() < bridge_length && weight >= total + waiting.peek().size) {
        total += waiting.peek().size;
        truckQueue.offer(waiting.poll());
      }
      answer++;
    }

    return answer + bridge_length;
  }

  public static void main(String[] args) {
    Solution3 s = new Solution3();
    System.out.println(s.solution(100, 100, new int[] { 10 }));
  }
}