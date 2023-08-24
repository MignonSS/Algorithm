import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> called = new HashSet<>();
        char prevLast = ' ';

        for (int i = 0; i < words.length; i++) {
            if ((i != 0 && !words[i].startsWith(String.valueOf(prevLast)))
                    || called.contains(words[i]) || words[i].length() == 1) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            } else {
                called.add(words[i]);
                prevLast = words[i].charAt(words[i].length() - 1);
            }
        }
        return new int[]{0, 0};
    }
}