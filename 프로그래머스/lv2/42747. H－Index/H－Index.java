import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int min = Integer.MAX_VALUE;
        int thesisCount = 0;

        Arrays.sort(citations);

        // 오름차순 정렬 후 마지막 요소부터 체크
        for (int i = citations.length - 1; i >= 0; i--) {
            thesisCount++;
            int curCitation = citations[i];
            min = Math.min(curCitation, min);

            if (thesisCount > min) break;
        }

        if (thesisCount > min) thesisCount--;

        return thesisCount;
    }
}