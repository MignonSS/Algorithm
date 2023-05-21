class Solution {
    public String solution(int[] numbers, String hand) {

        int curL = 10;
        int curR = 12;

        StringBuilder sb = new StringBuilder();
        
        for (int num : numbers) {
            if (num == 0) num = 11;
            if (num % 3 == 1) { // num = 1, 4, 7
                sb.append("L");
                curL = num;
            } else if (num % 3 == 0) {
                sb.append("R");
                curR = num;
            } else {
                int disFromL = getDistance(curL, num);
                int disFromR = getDistance(curR, num);

                if (disFromL < disFromR || (disFromL == disFromR && hand.equals("left"))) {
                    sb.append("L");
                    curL = num;
                } else {
                    sb.append("R");
                    curR = num;
                }
            }
        }

        return sb.toString();
    }

    private int getDistance(int from, int to) {
        if (from % 3 != 2) {
            if (from % 3 == 0) from -= 2;
            if (Math.abs(from - to) >= 8) return 4;
            if (Math.abs(from - to) >= 5) return 3;
            if (Math.abs(from - to) >= 2) return 2;
            else return 1;
        } else {
            if (from == 0) from = 11;
            return Math.abs(from - to) / 3;
        }
    }
}