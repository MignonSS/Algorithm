import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String s) {
        String[] strings = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        List<String> answer = new ArrayList<>();

        for (String str : strings) {
            String[] split = str.split(",");

            for (String str2 : split) {
                if (!answer.contains(str2)) {
                    answer.add(str2);
                    break;
                }
            }
        }

        return answer.stream().mapToInt(Integer::parseInt).toArray();
    }
}