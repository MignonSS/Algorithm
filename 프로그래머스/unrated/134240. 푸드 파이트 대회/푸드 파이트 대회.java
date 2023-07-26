class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < food.length; i++) {
            if (food[i] < 2) continue;
            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }

        StringBuilder reverse = new StringBuilder(sb).reverse();
        return sb.append("0").append(reverse).toString();
    }
}