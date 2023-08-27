import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            if (k <= 0) return (i + 1);
        }
        return list.size();
    }
}