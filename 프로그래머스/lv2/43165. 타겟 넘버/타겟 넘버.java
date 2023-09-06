class Solution {
    static int[] mark;
    static int answer;

    public void dfs(int depth, int[] numbers, int target) {
        if (depth == numbers.length) {
            int temp = 0;
            for (int i = 0; i < numbers.length; i++) {
                temp += mark[i] * numbers[i];
            }
            if (temp == target) answer++;
        } else {
            mark[depth] = 1;
            dfs(depth + 1, numbers, target);
            mark[depth] = -1;
            dfs(depth + 1, numbers, target);
        }
    }

    public int solution(int[] numbers, int target) {
        mark = new int[numbers.length];
        dfs(0, numbers, target);
        return answer;
    }
}