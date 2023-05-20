import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[10];

        for (int i = 0; i < Y.length(); i++) {
            arr[Y.charAt(i) - 48]++;
        }

        int zero = arr[0];

        for (int i = 0; i < X.length(); i++) {
            int n = X.charAt(i) - 48;
            if (arr[n] > 0) {
                arr[n]--;
                answer.append(n);
            }
        }

        if (answer.length() == 0) return "-1";
        if (answer.length() == zero) return "0";

        String[] str = answer.toString().split("");
        Arrays.sort(str, Comparator.reverseOrder());

        return String.join("", str);
    }
}