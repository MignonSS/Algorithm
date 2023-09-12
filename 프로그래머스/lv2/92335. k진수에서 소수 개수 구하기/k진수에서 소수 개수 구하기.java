class Solution {
    public int solution(int n, int k) {
        String[] arr = Integer.toString(n, k).split("0");
        int answer = 0;
        
        Loop : for (String s : arr) {
            if (s.length() == 0) continue;
            long num = Long.parseLong(s);
            if (num == 1) continue;
            for (long l = 2; l <= Math.sqrt(num); l++) {
                if (num % l == 0) continue Loop;
            }
            answer++;
        }
        return answer;
    
    }
}