import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantIdxMap = new HashMap<>();
        int[] discountCheck = new int[want.length];
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            wantIdxMap.put(want[i], i);
        }

        for (int i = 0; i < 10; i++) {
            if (wantIdxMap.containsKey(discount[i])) {
                discountCheck[wantIdxMap.get(discount[i])]++;
            }
        }

        for (int i = 0; i < discount.length - 9; i++) {
            int start = i;
            int end = i + 9;

            if (i != 0) {
                if (wantIdxMap.containsKey(discount[start - 1])) discountCheck[wantIdxMap.get(discount[start - 1])]--;
                if (wantIdxMap.containsKey(discount[end])) discountCheck[wantIdxMap.get(discount[end])]++;
            }

            if (check(number, discountCheck)) answer++;
        }
        return answer;
    }

    private boolean check(int[] number, int[] discountCheck) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] != discountCheck[i]) return false;
        }
        return true;
    }
}