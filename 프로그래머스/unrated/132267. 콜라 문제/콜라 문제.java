class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (a <= n) {
            int obtain = (n / a) * b;
            answer += obtain;
            n = (n % a) + obtain;
        }
        
        return answer;
    }
}