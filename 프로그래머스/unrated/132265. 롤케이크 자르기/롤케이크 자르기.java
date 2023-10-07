import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        int littleBroSize = map.keySet().size();

        Set<Integer> bigBro = new HashSet<>();

        for (int t : topping) {
            bigBro.add(t);
            map.put(t, map.getOrDefault(t, 0) - 1);
            if (map.get(t) == 0) littleBroSize--;

            if (bigBro.size() == littleBroSize) {
                answer++;
            }
        }

        return answer;
    }
}