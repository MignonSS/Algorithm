class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int sum = 0; 
        
        for (int i = 0; i < sides.length; i++) {
            max = Math.max(max, sides[i]);
            sum += sides[i];
        }
        
        return sum - 2 * max > 0 ? 1 : 2;
        
    }
}