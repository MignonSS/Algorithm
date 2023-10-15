import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) bridge.add(0);

        Queue<Integer> standing = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            standing.add(truck_weights[i]);
        }

        int crossingTruck = 0;
        int crossingWeight = 0;
        int time = 0;

        while (!standing.isEmpty()) {
            int cur = bridge.poll();
            time++;
            crossingWeight -= cur;

            if (cur > 0) crossingTruck--;
            if (crossingWeight + standing.peek() > weight) {
                bridge.add(0);
                continue;
            }
            if (standing.isEmpty() || crossingWeight + standing.peek() > weight || crossingTruck == bridge_length) continue;

            int newTruck = standing.poll();
            bridge.add(newTruck);
            crossingWeight +=  newTruck;
            crossingTruck++;
        }

        return time + bridge_length;
    }
}