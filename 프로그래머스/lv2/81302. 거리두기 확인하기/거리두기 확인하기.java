class Solution {
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        // places[i] : 하나의 룸 -> {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"} -> char[][]
        for (int i = 0; i < places.length; i++) {
            char[][] room = new char[places[i].length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = places[i][j].toCharArray();
            }
            if (isDistanced(room)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                // 거리두기 검사 - 1. 상/하/좌/우 중 파티션이 아닌 곳 찾기
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
                    switch (room[ny][nx]) {
                        case 'P': return false;
                        case 'O':
                            // 추가 검사 필요
                            if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                            break;
                    }
                }
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
}