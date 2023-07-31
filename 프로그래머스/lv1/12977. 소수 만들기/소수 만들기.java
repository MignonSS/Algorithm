class Solution {
    public int solution(int[] nums) {
        int count = 0;
        int[] check = new int[3000];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (check[sum] == 1) {
                        count++;
                        continue;
                    }
                    if (check[sum] == -1) continue;

                    for (int x = 2; x <= Math.sqrt(sum); x++) {
                        if (sum % x == 0) {
                            check[sum] = -1;
                            continue;
                        }
                    }
                    if (check[sum] == -1) continue;
                    check[sum] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}