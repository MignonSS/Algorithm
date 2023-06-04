import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();

        int order = -1;

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                list.add(words[i]);
                continue;
            }
            String prevEnd = words[i - 1].substring(words[i - 1].length() - 1);
            if (words[i].startsWith(prevEnd) && !list.contains(words[i])) {
                list.add(words[i]);
                continue;
            }
            order = i + 1;
            break;
        }

        if (order == -1) return new int[]{0, 0};
        int[] answer = new int[2];

        answer[1] = (int) Math.ceil(order * 1.0 / n);
        answer[0] = order % n == 0 ? n : order % n;

        return answer;
    }
}