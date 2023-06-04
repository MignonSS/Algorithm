class Solution
{
    public int solution(String s)
    {
        int[] arr = new int[500000];
        int point = 0;

        for (char c : s.toCharArray()) {
            if (point > 0 && arr[point - 1] == c) {
                arr[--point] = 0;
                continue;
            }
            arr[point++] = c;
        }

        return point == 0 ? 1 : 0;
    }
}