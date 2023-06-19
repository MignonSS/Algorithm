import java.util.*;
class Solution {
    private static String[][] procedences = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split("")
    };

    public long solution(String expression) {
        // "+-*" (index 1) 을 구분자로 하여 token 생성, true (index 2) : 구분자를 토큰에 포함할지 여부
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        // 토큰 -> List
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        // 각 procedence 에 따라 expression 계산 및 결과의 최댓값 찾기
        long max = 0;
        for (String[] procedence : procedences) {
            // 리스트 자체가 바뀌므로 새 리스트로 복사하여 전달, 절대값 계산
            long value = Math.abs(calculate(new ArrayList<>(tokens), procedence));
            max = Math.max(value, max);
        }
        return max;
    }

    private long calculate(long left, long right, String op) {
        switch (op) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            default:
                return 0;
        }
    }

    private long calculate(List<String> tokens, String[] procedence) {
        for (String op : procedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long left = Long.parseLong(tokens.get(i - 1));
                    long right = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(left, right, op);

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
}