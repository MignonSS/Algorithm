import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] check = new int[123];
        Arrays.fill(check, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            answer[i] = check[c] == -1 ? check[c] : i - check[c];
            check[c] = i;
        }

        return answer;
    }
}