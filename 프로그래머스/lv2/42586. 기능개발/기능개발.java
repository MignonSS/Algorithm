import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainDate = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (!queue.isEmpty() && queue.peek() < remainDate) {
                list.add(queue.size());
                queue.clear();
            }
            queue.offer(remainDate);
        }

        list.add(queue.size());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}