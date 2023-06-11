import java.util.*;
class Solution {
public int solution(String s) {

        int answer = 0;
        if (isProper(s)) {
            answer++;
        }

        for (int i = 1; i < s.length(); i++) {
            s = rotationBracket(s);
            if (isProper(s)) {
                answer++;
            }
        }

        return answer;
    }

    // 괄호 회전
    private String rotationBracket(String s) {
        return s.substring(1) + s.charAt(0);
    }

    // 올바른 괄호 문자열인지 검사
    private boolean isProper(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' || stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                switch (s.charAt(i)) {
                    case ')':
                        isProperBracket(stack, '(');
                        break;
                    case '}':
                        isProperBracket(stack, '{');
                        break;
                    case ']':
                        isProperBracket(stack, '[');
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    private void isProperBracket(Stack<Character> stack, char bracket) {
        if (stack.peek() == bracket) stack.pop();
    }
}