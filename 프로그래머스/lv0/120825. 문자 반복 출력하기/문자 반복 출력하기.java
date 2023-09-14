class Solution {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (String s : my_string.split("")) {
            answer.append(s.repeat(n));
        }
        
        return answer.toString();
    }
}