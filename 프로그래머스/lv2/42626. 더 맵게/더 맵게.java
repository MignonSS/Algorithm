import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : scoville) minHeap.add(i);

        int answer = 0;

        while (minHeap.peek() < K) {
            if (minHeap.size() == 1) return -1;
            minHeap.add(minHeap.poll() + minHeap.poll() * 2);
            answer++;
        }

        return answer;
    }
}