import java.util.*;
class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            min = Math.min(min, compress(s, i));
        }

        return min;
    }

    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 1;

        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
                continue;
            }
            if (count >= 2) builder.append(count);
            builder.append(last);
            last = token;
            count = 1;
        }

        if (count >= 2) builder.append(count);
        builder.append(last);

        return builder.length();
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();

        for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
            int endIdx = startIdx + length;
            if (endIdx > source.length()) endIdx = source.length();
            tokens.add(source.substring(startIdx, endIdx));
        }
        return tokens;
    }
}