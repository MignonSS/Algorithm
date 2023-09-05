import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] strings = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        Set<String> set = new HashSet<>();
        int[] answer = new int[strings.length];
        int idx = 0;

        for (String str : strings) {
            String[] split = str.split(",");

            for (String str2 : split) {
                if (!set.contains(str2)) {
                    answer[idx++] = Integer.parseInt(str2);
                    set.add(str2);
                }
            }
        }

        return answer;
    }
}