import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportedCount = new HashMap<>();
        Map<String, HashSet<String>> myReportIds = new HashMap<>();

        Arrays.stream(report)
                .distinct() // 한 유저가 동일한 아이디를 신고하는 경우 제외
                .map(str -> str.split(" "))
                .forEach(arr -> {
                    reportedCount.put(arr[1], reportedCount.getOrDefault(arr[1], 0) + 1); // 신고당한 횟수 카운트

                    HashSet<String> reportedSet = myReportIds.getOrDefault(arr[0], new HashSet<>());
                    reportedSet.add(arr[1]);
                    myReportIds.put(arr[0], reportedSet); // 한 유저(key)가 누구를 신고했는지(value) 맵으로 표현  
                });

        // id_list 의 각 id마다 해당 id가 신고한 유저 목록(myReportIds) 과 banList를 비교해 메일 받는 횟수 answer 에 기록
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> curReportIds = myReportIds.getOrDefault(id_list[i], new HashSet<>());
            for (String curReportId : curReportIds) {
                if (reportedCount.getOrDefault(curReportId, 0) >= k) answer[i]++;
            }
        }

        return answer;
    }
}