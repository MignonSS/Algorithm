class Solution {
    public int[] solution(String s) {
        int removeZeroCount = 0;
        int repeatCount = 0;
        String temp = s;
        int curLength = s.length();
        
        while (temp.length() > 1) {
            int curRemoved = 0;
            for (int i = temp.length() - 1; i >= 0; i--) {
                if (temp.charAt(i) == '0') curRemoved++;
            }
            removeZeroCount += curRemoved;
            temp = Integer.toString(curLength - curRemoved, 2);
            curLength = temp.length();
            repeatCount++;
        }
        return new int[]{repeatCount, removeZeroCount};
    }
}