class Solution {
    public int solution(int n) {
        int rest = n % 7;
        int share = n / 7;
        
        return rest == 0 ? share : share + 1;
    }
}