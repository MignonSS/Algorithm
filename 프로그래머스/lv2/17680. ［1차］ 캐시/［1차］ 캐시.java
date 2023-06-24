import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int time = 0;

        for (String city : cities) {
            city = city.toUpperCase();
            if (cacheSize == 0) {
                time += 5;
            } else if (cache.contains(city)) {
                cache.remove(city);
                time += 1;
            } else {
                if (cache.size() == cacheSize) cache.poll();
                time += 5;
            }
            cache.add(city);
        }

        return time;
    }
}