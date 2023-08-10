class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int curLeft = 10, curRight = 12;

        for (int number : numbers) {
            if (number == 0) number = 11;
            if (number % 3 == 1) { // number = 1, 4, 7
                answer.append("L");
                curLeft = number;
            } else if (number % 3 == 0) { // number = 3, 6, 9
                answer.append("R");
                curRight = number;
            } else {
                int disFromL = getDistance(curLeft, number);
                int disFromR = getDistance(curRight, number);

                if (disFromL < disFromR || (disFromL == disFromR && hand.equals("left"))) {
                    answer.append("L");
                    curLeft = number;
                } else {
                    answer.append("R");
                    curRight = number;
                }
            }
        }
        return answer.toString();
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