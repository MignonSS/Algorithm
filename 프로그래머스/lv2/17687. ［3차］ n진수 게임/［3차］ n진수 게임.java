class Solution {
    public String solution(int n, int t, int m, int p) {
        char[] arr = new char[t * m];
        StringBuilder answer = new StringBuilder();

        int temp = 0;
        String tempStr = "";
        int digitNum = 0;

        for (int i = 0, j = 0; i < t * m; i++) {
            if (digitNum == 0) {
                tempStr = Integer.toString(temp, n);
            }

            arr[i] = tempStr.charAt(digitNum++);

            if (digitNum == tempStr.length()) {
                temp++;
                digitNum = 0;
            }

            if ((i + 1) % m == (m == p ? 0 : p)) {
                answer.append(arr[i]);
            }
        }

        return answer.toString().toUpperCase();
    }
}