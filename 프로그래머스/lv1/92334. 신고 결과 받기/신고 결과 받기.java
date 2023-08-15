import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportedCount = new HashMap<>();
        Map<String, HashSet<String>> myReportIds = new HashMap<>();
        HashSet<String> banList = new HashSet<>();
        
        Arrays.stream(report)
                .distinct() // 한 유저가 동일한 아이디를 신고하는 경우 제외
                .map(str -> str.split(" "))
                .forEach(arr -> {
//                    if (arr[0].equals(arr[1])) return;
                    reportedCount.put(arr[1], reportedCount.getOrDefault(arr[1], 0) + 1);
                    if (reportedCount.get(arr[1]) >= k) banList.add(arr[1]); 
                    
                    HashSet<String> reportedSet = myReportIds.getOrDefault(arr[0], new HashSet<>());
                    reportedSet.add(arr[1]);
                    myReportIds.put(arr[0], reportedSet);
                });

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> curReportIds = myReportIds.getOrDefault(id_list[i], new HashSet<>());
            for (String banId : banList) {
                if (curReportIds.contains(banId)) answer[i]++;
            }
        }
        
        return answer;
    }
}