package Programmers.Level2;
import java.util.PriorityQueue;

public class 더_맵게 {

    public static void main(String[] args) {
        Solution42626 solution42626 = new Solution42626();
        System.out.println(solution42626.solution(new int[]{1, 1, 1, 1, 1, 1}, 15));
    }
}

class Solution42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = initQueue(scoville);
        int mixScoville;
        int answer = 0;
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            mixScoville = first + (second * 2);
            pq.add(mixScoville);
            answer++;
        }
        return answer;
    }

    private PriorityQueue<Integer> initQueue(int[] scoville) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sc: scoville) {
            pq.add(sc);
        }
        return pq;
    }
}
