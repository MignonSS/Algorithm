import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];

            // q에 순차적으로 numbers의 값을 넣고,
            // q의 값 중 가장 작은 값이 value보다 작다면 numbers의 해당 인덱스의 값을 value로 치환하고, 해당 값은 q에서 제거한다.
            // 현 상황에서의 현재 value보다 작은 값들은 모두 치환되며 q에서 빠지고 새로운 값들이 q에 들어가기 때문에, 가장 가까이에 있는 오른쪽의 더 큰 값이 값으로 지정된다.
            while (!q.isEmpty() && q.peek()[1] < value) {
                numbers[q.poll()[0]] = value;
            }

            q.add(new int[]{i, numbers[i]});
        }
        
        // q에 남아있는 (더 큰 값이 없거나 마지막 요소이거나) 요소들 -1 처리
        while (!q.isEmpty()) {
            numbers[q.poll()[0]] = -1;
        }

        return numbers;
    }
}