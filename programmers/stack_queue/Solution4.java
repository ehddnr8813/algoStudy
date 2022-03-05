package algoStudy.programmers.stack_queue;

import java.util.Arrays;
import java.util.Stack;

class Solution4 {

    static Stack<Integer> st = new Stack<>();

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                answer[st.peek()]= i -st.peek();
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            answer[st.peek()] = prices.length -1 - st.peek();
            st.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int answer[] = solution(new int[]{1,2,3,2,3});
        System.out.println(Arrays.toString(answer));
    }
}