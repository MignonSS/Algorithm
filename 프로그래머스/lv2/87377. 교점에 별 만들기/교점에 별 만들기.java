import java.util.*;

class Solution {
    private static class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point getIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    /**
     * 두 직선 line[i], line[j]
     * a1x + b1y + c1 = 0
     * a2x + b2y + c2 = 0
     */

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 두 직선 line[i], line[j] 의 교점 구해서 points 에 추가
                Point intersection = getIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) points.add(intersection);
            }
        }

        // 저장된 포인트들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;

        for (Point point : points) {
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }

        // 구한 최댓값, 최솟값을 이용해서 2차원 배열의 크기 결정
        // 배열의 크기는 차이만큼이 아니라 차이의 각 라인수이므로 +1
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        // char 2차원 배열 선언, 모든 값을 '.' 로 채워넣기
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 2차원 배열에 별 표시 : (x, y) -> 2차원 배열의 행/열 값으로 변환
        for (Point point : points) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            arr[y][x] = '*';
        }

        // 문자열 배열로 변환 후 리턴
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }
}