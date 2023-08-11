import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] arr = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        Map<Character, Integer> scoreMap = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char notAgree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            if (choices[i] < 4) {
                scoreMap.put(notAgree, scoreMap.getOrDefault(notAgree, 0) + (4 - choices[i]));
            } else if (choices[i] > 4) {
                scoreMap.put(agree, scoreMap.getOrDefault(agree, 0) + (choices[i] - 4));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int first = scoreMap.getOrDefault(arr[i][0], 0);
            int second = scoreMap.getOrDefault(arr[i][1], 0);

            answer += first >= second ? arr[i][0] : arr[i][1];
        }
        
        return answer;
    }
}