class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        int gcd = gcd(denom1, denom2);
        System.out.println("gcd : " + gcd);
        int lcm = denom1 * denom2 / gcd;
        System.out.println("lcm : " + lcm);

        int share1 = lcm / denom1;
        int share2 = lcm / denom2;
        System.out.println("share1 : " + share1 + ", share2 : " + share2);

        int numer3 = numer1 * share1 + numer2 * share2;
        int denom3 = lcm;

        int gcd2 = gcd(numer3, denom3);
        answer[0] = numer3 / gcd2;
        answer[1] = denom3 / gcd2;
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
    
}