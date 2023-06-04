class Solution {
    public int solution(int n) {
        int[] memo = new int[100002];
        return fibo(n, memo);
    }

    private int fibo(int n, int[] memo) {
        if (n <= 1) return memo[n] = n;
        if (memo[n] > 0) return memo[n];
        memo[n] = fibo(n - 1, memo) + fibo(n - 2, memo);
        if (memo[n] > 1234567) memo[n] %= 1234567;
        return memo[n];
    }
}