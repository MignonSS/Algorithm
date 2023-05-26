import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // terms 맵으로 변환
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            termsMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        // today : String -> int[]
        int[] todayArr = getDateArr(today);

        /** 수집일자 + 약관종류 나눈 배열로 만든 후 expired() 를 통해 확인
         * curPrivacy = String[]{{"2021.05.02", "A"}, ...}
         */

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] curPrivacy = privacies[i].split(" ");
            if (expired(todayArr, curPrivacy, termsMap)) list.add(i + 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /** // 년월일 문자를 int[] 배열로 변환
     * String input: "year.month.date"  (ex. 2023.05.26)
     * result[0]: year
     * result[1]: month
     * result[2]: day
     */
    private int[] getDateArr(String dayString) {
        String[] strArr = dayString.split("\\.");

        return new int[]{
                Integer.parseInt(strArr[0]),
                Integer.parseInt(strArr[1]),
                Integer.parseInt(strArr[2])
        };
    }

    private boolean expired(int[] today, String[] privacyAndTermArr, Map<String, Integer> termsMap) {
        int validTerms = termsMap.get(privacyAndTermArr[1]);
        int[] collected = getDateArr(privacyAndTermArr[0]);
        int[] expiredDate = new int[3];

        expiredDate[2] = collected[2] == 1 ? 28 : collected[2] - 1;
        expiredDate[1] = collected[2] == 1 ? collected[1] + validTerms - 1 : collected[1] + validTerms;

        int toAddYear = 0; 
        while (expiredDate[1] > 12) {
            expiredDate[1] -= 12;
            toAddYear++;
        }
        
        expiredDate[0] = collected[0] + toAddYear;

        // year 비교
        if (today[0] > expiredDate[0]) return true;
        if (today[0] < expiredDate[0]) return false;

        // year 동일 -> month 비교
        if (today[1] > expiredDate[1]) return true;
        if (today[1] < expiredDate[1]) return false;

        // year, month 동일 -> date 비교
        return today[2] > expiredDate[2];
    }
}