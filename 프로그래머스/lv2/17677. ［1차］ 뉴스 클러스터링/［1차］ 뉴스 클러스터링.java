import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) return 65536;
        if (str1.length() == 0 || str2.length() == 0) return 0;

        // 다중집합 만들기
        Map<String, Integer> map1 = getMultiSet(str1);
        Map<String, Integer> map2 = getMultiSet(str2);

        // 교집합, 합집합
        int intersectionSize = map1.keySet().stream()
                .filter(map2::containsKey)
                .mapToInt(str -> Math.min(map1.get(str), map2.get(str))).sum();
        int unionSize = map1.values().stream().mapToInt(Integer::intValue).sum()
                + map2.values().stream().mapToInt(Integer::intValue).sum()
                - intersectionSize;

        return (int) ((intersectionSize / (double) unionSize) * 65536);
    }

    private Map<String, Integer> getMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toUpperCase();

        for (int i = 0; i < str.length() - 1; i++) {
            String subStr = str.substring(i, i + 2).replaceAll("[^A-Z]", "");

            if (subStr.length() == 2) {
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }

        return map;
    }
}