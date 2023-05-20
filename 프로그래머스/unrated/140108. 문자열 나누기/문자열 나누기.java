import java.util.*;
class Solution {
    public int solution(String s) {

        return getDivCount(new ArrayList<>(), s).size();

    }

    private List<String> getDivCount(List<String> list, String str) {
        if (str.length() == 0) {
            return list;
        }

        char start = str.charAt(0);
        int sameCount = 0;
        int diffCount = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == start) sameCount++;
            else diffCount++;

            if (sameCount == diffCount) {
                list.add(str.substring(0, i + 1));
                return getDivCount(list, str.substring(i + 1));
            }
        }

        // sameCount, diffCount 가 다른 상태로 for 문 종료
        list.add(str);

        return list;
    }
}