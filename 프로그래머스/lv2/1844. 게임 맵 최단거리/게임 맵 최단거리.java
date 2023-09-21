import java.util.*;

class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int n = maps.length - 1;
        int m = maps[0].length - 1;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.y == n && cur.x == m) {
                return cur.distance;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && ny <= n && nx >= 0 && nx <= m && maps[ny][nx] == 1) {
                    maps[ny][nx] = 0;
                    queue.add(new Point(ny, nx, cur.distance + 1));
                }
            }
        }

        return -1;
    }
}

class Point {
    int y;
    int x;
    int distance;

    Point(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}