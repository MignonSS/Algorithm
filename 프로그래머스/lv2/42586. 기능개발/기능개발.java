import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int curComplete = 0;
        int idx = 0;

        List<Integer> list = new ArrayList<>();

        while (idx < progresses.length) {
            if (progresses[idx] + speeds[idx] * day < 100) {
                day++;

                if (curComplete != 0) {
                    list.add(curComplete);
                    curComplete = 0;
                }
                continue;
            }

            idx++;
            curComplete++;
        }

        list.add(curComplete);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}