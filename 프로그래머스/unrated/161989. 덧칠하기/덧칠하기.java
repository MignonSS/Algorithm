class Solution {
    public int solution(int n, int m, int[] section) {
        int curPainted = 0;
        int count = 0;

        for (int point : section) {
            if (point > curPainted) {
                count++;
                curPainted = point + m - 1; // point 지점부터(point 포함) roller 길이 m 만큼 칠했을 때 가장 마지막으로 칠해진 벽의 숫자
            }
        }
        return count;
    }
}