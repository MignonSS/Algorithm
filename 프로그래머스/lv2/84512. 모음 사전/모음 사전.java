import java.util.*;
class Solution {
    static char[] criteria = {'A', 'E', 'I', 'O', 'U'};
    List<String> wordList = new ArrayList<>();

    public int solution(String word) {
        dfs("");
        return wordList.indexOf(word);
    }

    private void dfs(String word) {
        wordList.add(word);

        if (word.length() == 5) return;

        for (char c : criteria) {
            dfs(word + c);
        }
    }
}