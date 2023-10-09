import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        Map<Long, Long> memo = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (memo.containsKey(numbers[i])) {
                answer[i] = memo.get(numbers[i]);
                continue;
            }

            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                // 10진수 -> 2진수 변환 : Integer.toBinaryString(int);
                String binaryString = Long.toBinaryString(numbers[i]);
                int idxOfZero = binaryString.lastIndexOf('0');

                String temp = "";
                if (idxOfZero == -1) {
                    temp = "10" + binaryString.substring(1);
                } else {
                    temp = binaryString.substring(0, idxOfZero) + "10" + binaryString.substring(idxOfZero + 2);
                }
                memo.put(numbers[i], answer[i] = Long.parseLong(temp, 2));
            }
        }

        return answer;
    }
}