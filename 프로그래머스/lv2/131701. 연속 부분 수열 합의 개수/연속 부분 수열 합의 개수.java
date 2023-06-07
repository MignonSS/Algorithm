import java.util.*;
class Solution {
    public int solution(int[] elements) {

        Set<Integer> sums = new HashSet<>();

        for (int elCount = 1; elCount <= elements.length; elCount++) {
            for (int startIdx = 0; startIdx < elements.length; startIdx++) {
                int sum = 0;
                for (int toAddIdx = startIdx; toAddIdx < startIdx + elCount; toAddIdx++) {
                    sum += elements[toAddIdx%(elements.length)];
                }
                sums.add(sum);
            }
        }
        return sums.size();
    }
}