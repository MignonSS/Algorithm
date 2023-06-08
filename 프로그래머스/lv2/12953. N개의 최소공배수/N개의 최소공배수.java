class Solution {
    public int solution(int[] arr) {

        int curLmc = 1;

        for (int i = 0; i < arr.length; i++) {
            int curGcd = gcd(arr[i], curLmc);
            curLmc = curLmc * arr[i] / curGcd;
        }
        
        return curLmc;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}