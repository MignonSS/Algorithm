import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        int[] arr = new int[elements.length * 2];
        System.arraycopy(elements, 0, arr, 0, elements.length);
        System.arraycopy(elements, 0, arr, elements.length, elements.length);

        int[] psum = new int[arr.length + 1]; // psum[1] = 원소 1개 합 idx 0까지의 합, psum[2] = 원소 2개 합, idx 0~1 까지의 합
        for (int i = 0; i < arr.length; i++) {
            psum[i + 1] = psum[i] + arr[i];
        }

        for (int elCount = 1; elCount <= elements.length; elCount++) {

            for (int startIdx = 0; startIdx < elements.length; startIdx++) {
                int endIdx = startIdx + elCount;
                int curSum = psum[endIdx] - psum[startIdx];
                sums.add(curSum);
            }

        }

        return sums.size();
    }
}