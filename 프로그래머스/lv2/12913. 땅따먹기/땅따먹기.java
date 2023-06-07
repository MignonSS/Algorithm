class Solution {
    int solution(int[][] land) {
        int[] curSum = new int[4];

        for (int i = 0; i < land.length - 1; i++) {
            for (int j = 0; j < 4; j++) { // 현재 줄
                int curMax = 0;
                for (int k = 0; k < 4; k++) { // 현재 줄에서 j열을 제외한 값들 중 최대값 구하기
                    if (k != j && land[i][k] > curMax) curMax = land[i][k];
                }
                land[i + 1][j] += curMax;
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }
}