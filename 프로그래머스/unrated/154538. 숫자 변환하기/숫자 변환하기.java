import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        int[][] arr = {{1, n}, {2, 0}, {3, 0}};
        Set<Integer> memo = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int L = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int curX = q.poll();

                for (int i = 0; i < 3; i++) {
                    int nextX = curX * arr[i][0] + arr[i][1];
                    if (memo.contains(nextX)) continue;
                    
                    if (nextX == y) return L;
                    if (nextX < y) {
                        q.add(nextX);
                        memo.add(nextX);
                    } 
                }
            }
            L++;
        }
        return -1;
    }
}