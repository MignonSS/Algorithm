import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length - 1];
        int secondLast = num_list[num_list.length - 2];

        int[] arr = Arrays.copyOf(num_list, num_list.length + 1);
        arr[arr.length - 1] = last > secondLast ? last - secondLast : last * 2; 
        return arr;
    }
}