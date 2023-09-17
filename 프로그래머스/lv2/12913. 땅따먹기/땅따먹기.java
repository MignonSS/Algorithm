import java.util.*;
class Solution {
    int solution(int[][] land) {
        for (int i = 0; i < land.length - 1; i++) {
            for (int j = 0; j < 4; j++) {
                int curMax = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j) 
                        curMax = Math.max(curMax, land[i][k]);
                }
                land[i + 1][j] += curMax;
            }
        }
        
        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}