class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom3 = denom1 * denom2;
        int numer3 = numer1 * denom2 + numer2 * denom1;
        
        int gcd = gcd(denom3, numer3);
        
        return new int[]{numer3 / gcd, denom3 / gcd};
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    
}