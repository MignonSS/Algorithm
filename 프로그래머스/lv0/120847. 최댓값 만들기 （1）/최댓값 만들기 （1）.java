class Solution {
    public int solution(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum = Math.max(sum, numbers[i] * numbers[j]);
            }
        }
        
        return sum;
    }
}