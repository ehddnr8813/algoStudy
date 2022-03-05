package algoStudy.programmers.stack_queue;


import java.util.LinkedList;
import java.util.Queue;

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
    for(int i=0; i< truck_weights.length; ++i){
      waiting.offer(new Truck(truck_weights[i], bridge_length));
    }

    int total=waiting.peek().size;
    int answer=1;
    truckQueue.offer(waiting.poll());

    while(!waiting.isEmpty()){

      for(Truck t: truckQueue) {
        t.timeLeft-=1;
      }

      if(truckQueue.peek().timeLeft == 0){
        Truck t = truckQueue.poll();
        total -= t.size;
      }

      if(truckQueue.size() < bridge_length && weight >= total + waiting.peek().size){
        total+= waiting.peek().size;
        truckQueue.offer(waiting.poll());
      }
       answer++;
    }

    return answer + bridge_length;
  }

  public static void main(String[] args) {
    Solution3 s = new Solution3();
    System.out.println(s.solution(100, 100, new int[]{10}));
  }
}