import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        if (k == 1) return 1;

        int[] count = new int[10_000_001];
        int total = k;

        for (int i = 0; i < tangerine.length; i++) {
            count[tangerine[i]]++;
            if (count[tangerine[i]] == k) return 1;
        }

        Arrays.sort(count);

        int answer = 0;
        for (int i = 0; total > 0; i++) {
            total -= count[10000000 - i];
            answer++;
        }
        
        return answer;
    }
}