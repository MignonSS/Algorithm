import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();

        for (String term : terms) {
            termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        return IntStream.range(0, privacies.length)
                        .mapToObj(i -> (privacies[i] + " " + i).split(" "))
                        .filter(p -> isExpired(today, p, termsMap))
                        .mapToInt(p -> Integer.parseInt(p[2]) + 1)
                        .toArray();
    }

    private boolean isExpired(String today, String[] privacyArr, Map<String, Integer> termsMap) {
        int todayToInt = getDateToInt(today, 0);
        int privacyToInt = getDateToInt(privacyArr[0], termsMap.get(privacyArr[1])) - 1; // 시작일을 포함해야 하기 때문에 결과값에서 -1

        return todayToInt > privacyToInt;
    }

    private int getDateToInt(String date, int term) {
        String[] dateArr = date.split("\\.");

        return  Integer.parseInt(dateArr[0]) * 12 * 28
                + Integer.parseInt(dateArr[1]) * 28
                + Integer.parseInt(dateArr[2])
                + term * 28;
    }
}