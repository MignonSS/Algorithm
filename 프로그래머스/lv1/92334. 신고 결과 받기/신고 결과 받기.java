import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportedCount = new HashMap<>();
        Map<String, HashSet<String>> myReportList = new HashMap<>();

        Arrays.stream(report)
                .distinct()
                .map(str -> str.split(" "))
                .forEach(arr -> {
                    if (arr[0].equals(arr[1])) return;
                    if (!reportedCount.containsKey(arr[1])) {
                        reportedCount.put(arr[1], 1);
                    } else {
                        reportedCount.replace(arr[1], reportedCount.get(arr[1]) + 1);
                    }
                    if (!myReportList.containsKey(arr[0])) {
                        myReportList.put(arr[0], new HashSet<>(List.of(arr[1])));
                    } else {
                        myReportList.get(arr[0]).add(arr[1]);
                    }

                });

        int[] receiveMailCount = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            if (!myReportList.containsKey(id_list[i])) continue;

            HashSet<String> myReports = myReportList.get(id_list[i]);

            for (String myReportId : myReports) {
                if (!reportedCount.containsKey(myReportId)) continue;
                if (reportedCount.get(myReportId) >= k) receiveMailCount[i]++;
            }
        }

        return receiveMailCount;
    }
}