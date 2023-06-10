import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        if (k == 1) return 1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            if (!map.containsKey(size)) {
                map.put(size, 1);
            } else {
                map.replace(size, map.get(size) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (sum >= k) return i + 1;
        }

        return list.size();
    }
}