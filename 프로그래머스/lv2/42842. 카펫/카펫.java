class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i != 0) continue;
            
            int yellowWidth = yellow / i;
            int yellowHeight = i;

            if ((yellowWidth+1) * 2 + (yellowHeight+1) * 2 != brown) continue;

            answer[0] = yellowWidth + 2;
            answer[1] = yellowHeight + 2;
            return answer;
        }
        return answer;
    }
}