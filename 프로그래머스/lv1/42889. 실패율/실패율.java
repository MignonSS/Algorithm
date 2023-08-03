import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stagePlayer = new int[N+2];
        int[] sum = new int[N+2];
        double[][] failureRate = new double[N+1][2];

        for (int i = 0; i < stages.length; i++) stagePlayer[stages[i]]++;

        return IntStream.rangeClosed(1, N)
                .peek(i -> sum[i] = sum[i - 1] + stagePlayer[i])
                .mapToObj(i -> stages.length - sum[i-1] == 0 ? new double[]{i * 1.0, 0.0} : new double[]{i * 1.0, stagePlayer[i] * 1.0 / (stages.length - sum[i-1])})
                .sorted((a, b) -> Double.compare(b[1], a[1]))
                .mapToInt(arr -> (int) arr[0])
                .peek(System.out::println)
                .toArray();
    }
}