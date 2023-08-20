class Solution {
    public int solution(int n) {
        int nCount = Integer.bitCount(n);

        while (true) {
            int nextCount = Integer.bitCount(++n);
            if (nCount == nextCount) break;
        }

        return n;
    }
}