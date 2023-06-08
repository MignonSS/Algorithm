class Solution {
    public long solution(int n) {
        long[] arr = new long[n + 2];

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 2L;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567; 
        }

        return arr[n];
    }
}