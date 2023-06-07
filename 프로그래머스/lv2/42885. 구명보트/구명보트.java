import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int lIdx = 0;
        int rIdx = people.length - 1;

        int boatCount = 0;

        while (lIdx <= rIdx) {
            if (people[lIdx] + people[rIdx] > limit) {
                rIdx--;
            } else {
                lIdx++;
                rIdx--;
            }
            boatCount++;
        }

        return boatCount;
    }
}