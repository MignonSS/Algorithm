import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
        int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
        Arrays.sort(temp);
        answer[i] = temp[commands[i][2] - 1];
    }

    return answer;

        // return Arrays.stream(commands)
        //         .mapToInt(command -> {
        //             int[] temp = Arrays.stream(Arrays.copyOfRange(array, command[0] - 1, command[1])).sorted().toArray();
        //             return temp[command[2] - 1];
        //         }).toArray();
    }
}