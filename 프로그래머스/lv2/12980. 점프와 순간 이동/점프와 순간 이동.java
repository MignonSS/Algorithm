import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            count++;
            n -= 1;
        }

        return count;
    }
}