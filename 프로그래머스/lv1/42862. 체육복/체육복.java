import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] check = new int[n + 1];
        int notBorrow = 0;

        for (int i : lost) check[i]--;

        for (int i : reserve) check[i]++;

        for (int i = 1; i <= n; i++) {
            if (check[i] == -1 && check[i - 1] == 1) {
                check[i]++;
                check[i - 1]--;
            } else if (check[i] == -1 && i < n && check[i + 1] == 1) {
                check[i]++;
                check[i + 1]--;
            }

            if (check[i] == -1) notBorrow++;
        }

        return n - notBorrow;
    }
}