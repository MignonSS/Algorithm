import java.util.*;

class Solution {
    Map<String, int[]> moveMap = Map.of(
            "N", new int[]{-1, 0},
            "S", new int[]{1, 0},
            "W", new int[]{0, -1},
            "E", new int[]{0, 1});

    public int[] solution(String[] park, String[] routes) {
        char[][] parkMatrix = new char[park.length][park[0].length()];
        int[] curPoint = new int[2];

        for (int row = 0; row < park.length; row++) {
            for (int col = 0; col < park[row].length(); col++) {
                parkMatrix[row][col] = park[row].charAt(col);
                if (parkMatrix[row][col] == 'S') {
                    curPoint[0] = row;
                    curPoint[1] = col;
                }
            }
        }

        for (String route : routes) {
            String[] curRoute = route.split(" ");
            if (canMove(curPoint, parkMatrix, curRoute[0], Integer.parseInt(curRoute[1]))) {
                curPoint[0] += moveMap.get(curRoute[0])[0] * Integer.parseInt(curRoute[1]);
                curPoint[1] += moveMap.get(curRoute[0])[1] * Integer.parseInt(curRoute[1]);
            }
        }

        return curPoint;
    }

    private boolean canMove(int[] curPoint, char[][] parkMatrix, String op, int moveCnt) {
        if (moveCnt == 0) {
            return true;
        }

        int nextY = curPoint[0] + moveMap.get(op)[0];
        int nextX = curPoint[1] + moveMap.get(op)[1];

        if (nextY >= parkMatrix.length || nextY < 0 || nextX >= parkMatrix[nextY].length || nextX < 0 || parkMatrix[nextY][nextX] == 'X') {
            return false;
        }

        int[] nextPoint = new int[]{nextY, nextX};
        return canMove(nextPoint, parkMatrix, op, moveCnt - 1);
    }
}