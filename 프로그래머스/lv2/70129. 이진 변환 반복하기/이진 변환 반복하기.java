class Solution {
    public int[] solution(String s) {
        int convertCnt = 0;
        int removedZeroCnt = 0;

        while (!s.equals("1")) {
            String temp = s.replaceAll("0", "");
            removedZeroCnt += (s.length() - temp.length());
            s = Integer.toBinaryString(temp.length());
            convertCnt++;
        }

        return new int[]{convertCnt, removedZeroCnt};
    }
}