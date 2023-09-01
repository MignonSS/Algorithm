import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String s) {
        List<String> list = Arrays.stream(s.substring(2, s.length() - 2).split("\\},\\{"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        List<String> answer = new ArrayList<>();

        for (String str : list) {
            String[] split = str.split(",");

            if (split.length == 1) {
                answer.add(split[0]);
                continue;
            }

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