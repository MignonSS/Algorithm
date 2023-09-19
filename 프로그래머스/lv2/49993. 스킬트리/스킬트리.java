import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
                .filter(tree -> skill.startsWith(tree.replaceAll("[^" + skill + "]", "")))
                .count();
    }
}