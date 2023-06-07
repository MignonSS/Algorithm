import java.util.*;
class Solution {
    public int solution(int[] elements) {

        Set<Integer> sums = new HashSet<>();
        int start = 0;

        for (int i = 0; i < elements.length; i++) {
            int n = 1;
            int idx = i;
            int sum = 0;

            while (n <= elements.length) {
                sum += elements[idx++];
                sums.add(sum);
                if (idx >= elements.length) idx = 0;
                n++;
            }
        }
        return sums.size();
    }
}