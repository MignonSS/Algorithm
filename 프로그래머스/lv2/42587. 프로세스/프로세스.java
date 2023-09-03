import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            q.offer(i);
            pq.offer(priorities[i]);
        }

        while (true) {
            int curLocation = q.poll();

            if (map.get(curLocation) != pq.peek()) {
                q.offer(curLocation);
                continue;
            }

            pq.poll();

            if (curLocation == location) {
                break;
            }
        }

        return priorities.length - pq.size();
    }
}