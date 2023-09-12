import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++)
            map.put(String.valueOf(c), c - 'A' + 1);
        
        Queue<String> q = new LinkedList<>(Arrays.stream(msg.split("")).collect(Collectors.toList()));
        StringBuilder curStr = new StringBuilder(q.poll());
        
        while (!q.isEmpty()) {
            String nextStr = curStr + q.peek();

            if (!map.containsKey(nextStr)) {
                map.put(nextStr.toString(), map.size() + 1); // 사전 추가 (w + c)
                answer.add(map.get(curStr.toString())); // 출력 (w)
                curStr.setLength(0);
            }
            curStr.append(q.poll());
        }
        
        answer.add(map.get(curStr.toString()));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}