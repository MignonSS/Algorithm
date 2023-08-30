import java.util.*;
class Solution {
    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            s = rotationBracket(s);
            if (isProper(s)) {
                count++;
            }
        }

        return count;
    }

    private String rotationBracket(String s) {
        return new StringBuilder(s).append(s.charAt(0)).deleteCharAt(0).toString();
    }

    private boolean isProper(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' || stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                switch (s.charAt(i)) {
                    case ')':
                        checkBracket(stack, '(');
                        break;
                    case '}':
                        checkBracket(stack, '{');
                        break;
                    case ']':
                        checkBracket(stack, '[');
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    private void checkBracket(Stack<Character> stack, char c) {
        if (stack.peek() == c) stack.pop();
    }
}