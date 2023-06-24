import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String sort = clothe[1];
            if (map.containsKey(sort)) {
                map.replace(sort, map.get(sort) + 1);
            } else {
                map.put(sort, 1);
            }
        }

        int count = 1;

        for (Integer value : map.values()) {
            count *= (value + 1);
        }

        return count - 1;
    }
}