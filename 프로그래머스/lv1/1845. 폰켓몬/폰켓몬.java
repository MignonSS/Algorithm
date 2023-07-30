import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int getCount = nums.length / 2;

        for (int num : nums) {
            set.add(num);
        }

        return set.size() >= getCount ? getCount : set.size();
    }
}