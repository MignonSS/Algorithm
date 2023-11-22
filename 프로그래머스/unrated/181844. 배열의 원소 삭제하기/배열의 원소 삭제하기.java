import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int i = 0; i < delete_list.length; i++) deleteSet.add(delete_list[i]);
        
        return Arrays.stream(arr).filter(i -> !deleteSet.contains(i)).toArray();
        
    }
}