import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        if (lost.length == 0) return n;
        if (reserve.length == 0) return n - lost.length;

        boolean[] rNums = new boolean[n + 2];
        for (int num : reserve) rNums[num] = true;

        Arrays.sort(lost);

        int lostStudentCount = lost.length;

        for (int i = 0; i < lost.length; i++) {
            if (rNums[lost[i]]) {
                lostStudentCount--;
                rNums[lost[i]] = false;
                lost[i] = 0;
            }
        }
        
        for (int i : lost) {

            if (i == 0) continue;

            if (rNums[i-1]) {
                rNums[i-1] = false;
                lostStudentCount--;
                continue;
            }

            if (rNums[i+1]) {
                rNums[i+1] = false;
                lostStudentCount--;
            }
        }
        return n - lostStudentCount;
    }
}