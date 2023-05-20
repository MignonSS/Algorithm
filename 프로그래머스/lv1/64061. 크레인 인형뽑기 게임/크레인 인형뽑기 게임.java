import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        int curDoll = 0;

        for (int col : moves) {

            for (int i = 0; i < board.length; i++) {
                boolean picked = false;

                if (board[i][col-1] != 0) {
                    curDoll = board[i][col-1];
                    board[i][col-1] = 0;
                    picked = true;

                    if (!stack.isEmpty() && stack.peek() == curDoll) {
                        count += 2;
                        stack.pop();
                    } else {
                        stack.push(curDoll);
                    }

                }

                if (picked) break;
            }
        }

        return count;
    }
}