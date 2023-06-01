class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        int countSum = 0;

        while (true) {
            countSum += ++count;
            if (countSum > n) break;
            if ((n - countSum) % count == 0) answer++;
        }

        return answer;
    }
}