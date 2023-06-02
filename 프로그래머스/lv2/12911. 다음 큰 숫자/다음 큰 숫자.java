class Solution {
    public int solution(int n) {
        int answer = 0;

        int nCount = 0;
        int temp = n;
        while (temp > 0) {
            if (temp % 2 == 1) nCount++;
            temp /= 2;
        }

        int toAdd = 1;

        while(true) {
            int curNum = n + toAdd;
            int curOneCount = 0;
            while (curNum > 0) {
                if (curNum % 2 == 1) curOneCount++;
                curNum /= 2;
            }
            if (curOneCount == nCount) break;
            toAdd++;
        }

        return n + toAdd;
    }
}