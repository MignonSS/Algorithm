class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        int[] skipChar = new int[125];
        for (char c : skip.toCharArray()) skipChar[c] = 1;

        for (char c : s.toCharArray()) {
            int curChar = c;
            int moveCount = 0;
            while (moveCount < index) {
                if (curChar + 1 > 122) curChar -= 26;
                if (skipChar[curChar + 1] == 0) moveCount++;
                curChar++;
            }
            sb.append((char)curChar);
        }

        return sb.toString();
    }
}