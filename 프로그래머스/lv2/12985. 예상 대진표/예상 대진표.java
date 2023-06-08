class Solution
{
    public int solution(int n, int a, int b) {
        return getRound(1, a, b);
    }

    public int getRound(int round, int a, int b) {
        if (Math.abs(a - b) == 1 && Math.min(a, b) % 2 != 0) {
            return round;
        }
        return getRound(round + 1, (a + 1) / 2, (b + 1) / 2);
    }
}