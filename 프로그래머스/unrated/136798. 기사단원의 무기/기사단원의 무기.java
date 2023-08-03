class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;

        for (int i = 1; i <= number; i++) {
            int curCount = 0;

            for (int j = 1; j * j <= i; j++) {
                if (i == 1 || j * j == i) curCount += 1;
                else if (i % j == 0) curCount += 2;
            }

            sum = (curCount) > limit ? sum + power : sum + (curCount);
        }

        return sum;
    }
}