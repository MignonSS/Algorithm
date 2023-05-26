import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String, int[]> moveMap = Map.of(
                "N", new int[]{-1, 0},
                "S", new int[]{1, 0},
                "W", new int[]{0, -1},
                "E", new int[]{0, 1});

        char[][] parkMatrix = new char[park.length][park[0].length()];
        int[] start = new int[2];
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                parkMatrix[i][j] = park[i].charAt(j);
                if (parkMatrix[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            int[] direction = moveMap.get(route[0]);
            int moveCount = Integer.parseInt(route[1]);
            int[] temp = new int[]{start[0], start[1]};

            while (moveCount > 0) {
                if (!canMove(temp, direction, parkMatrix)) break;
                temp[0] = temp[0] + direction[0];
                temp[1] = temp[1] + direction[1];
                moveCount--;
            }

            if (moveCount > 0) continue;

            start[0] = temp[0];
            start[1] = temp[1];
        }
        
        return start;
    }


    private boolean canMove(int[] start, int[] toMove, char[][] parkMatrix) {
        int maxH = parkMatrix.length - 1;
        int maxW = parkMatrix[0].length - 1;

        int[] next = new int[]{start[0] + toMove[0], start[1] + toMove[1]};

        if (next[0] < 0 || next[0] > maxH || next[1] < 0 || next[1] > maxW) return false;
        return parkMatrix[next[0]][next[1]] != 'X';
    }
}