class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] keyCount = new int[91];

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char curChar = keymap[i].charAt(j);
                if (keyCount[curChar] == 1) continue;
                if (keyCount[curChar] == 0 || keyCount[curChar] > j+1) keyCount[curChar] = j+1;
            }
        }

        for (int x = 0; x < targets.length; x++) {
            int countSum = 0;
            for (int y = 0; y < targets[x].length(); y++) {
                char curTargetChar = targets[x].charAt(y);
                if (keyCount[curTargetChar] == 0) {
                    countSum = -1;
                    break;
                }
                countSum += keyCount[curTargetChar];
            }
            answer[x] = countSum;
        }

        return answer;
    }
}