class Solution {
    public int solution(int n, int k) {
        String baseK = Integer.toString(n, k) + "0";

        int start = 0;
        int answer = 0;

        for (int i = 1; i < baseK.length(); i++) {
            if (baseK.charAt(i - 1) == '0' && baseK.charAt(i) != '0') {
                start = i;
            } else if (baseK.charAt(i - 1) != '0' && baseK.charAt(i) == '0') {
                String subStr = baseK.substring(start, i);
                if (isPrime(subStr)) answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(String numStr) {
        long num = Long.parseLong(numStr);

        if (num == 1) return false;
        if (num == 2) return true;

        for (long i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}