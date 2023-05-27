class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (s.charAt(i-1) == ' ') sb.append(Character.toUpperCase(cur));
            else sb.append(Character.toLowerCase(cur));
        }

        return sb.toString();
    }
}