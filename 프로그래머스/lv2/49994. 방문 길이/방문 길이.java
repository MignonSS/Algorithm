import java.util.*;

class Solution {
    static Map<Character, int[]> dirMap = Map.of(
            'U', new int[]{0, 1},
            'D', new int[]{0, -1},
            'R', new int[]{1, 0},
            'L', new int[]{-1, 0}
    );
    static Map<Character, Character> dirPair = Map.of(
            'U', 'D',
            'D', 'U',
            'R', 'L',
            'L', 'R'
    );
    static Map<String, Point> map = new HashMap<>();
    
    public int solution(String dirs) {
        int answer = 0;

        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                map.put(i + "," + j, new Point(i, j));
            }
        }

        Point curPoint = map.get("0,0");

        for (char c : dirs.toCharArray()) {
            int nextX = curPoint.x + dirMap.get(c)[0];
            int nextY = curPoint.y + dirMap.get(c)[1];

            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) continue;
                                                            
            Point nextPoint = map.get(nextX + "," + nextY);

            if (curPoint.passed.add(c) && nextPoint.passed.add(dirPair.get(c)))
                answer++;

            curPoint = nextPoint;
        }

        return answer;
    }
}

class Point {
    int x, y;

    Set<Character> passed = new HashSet<>();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}