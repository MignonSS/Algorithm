class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : s.split(" ")) {
            int num = Integer.parseInt(str);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return min + " " + max;
    }
}