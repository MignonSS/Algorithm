import java.util.*;
class Solution {
    public int solution(String s) {

             char prev = '1';
        int sameCount = 0, diffCount = 0, answer = 0;

        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                sameCount++;
                answer++;
            } else if (prev == c) {
                sameCount++;
            } else {
                diffCount++;
            }

            if (sameCount == diffCount) {
                prev = '1';
                sameCount = 0;
                diffCount = 0;
            }
        }
        
        return answer;

    }
}