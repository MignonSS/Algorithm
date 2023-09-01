import java.util.*;
class Solution {
    private static Map<Character, Character> pair = Map.of(')', '(', '}', '{', ']', '[');

    public int solution(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            s = sb.append(s.charAt(0)).deleteCharAt(0).toString();
            if (isProper(s)) count++;
        }
        return count;
    }

    // 현재 문자열이 올바른 괄호 문자열인지 검사
    private boolean isProper(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);

            if (!pair.containsKey(curC) || stack.isEmpty()) stack.push(curC);
            else checkBracket(stack, pair.get(curC));
        }
        return stack.isEmpty();
    }

    // 닫는 괄호가 올바른 위치인지 검사 
    private void checkBracket(Stack<Character> stack, char c) {
        if (stack.peek() == c) stack.pop();
    }
}