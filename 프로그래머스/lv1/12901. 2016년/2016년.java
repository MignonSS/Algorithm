class Solution {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int total = 0;

        for (int i = 1; i <= a; i++) {
            if (i == a) {
                total += (b - 1);
            } else {
                switch (i) {
                    case 2:
                        total += 29;
                        break;
                    case 4: case 6: case 9: case 11:
                        total += 30;
                        break;
                    default:
                        total += 31;
                }
            }
        }

        int dayIndex = (total + 5) % 7;
        return days[dayIndex];
    }
}