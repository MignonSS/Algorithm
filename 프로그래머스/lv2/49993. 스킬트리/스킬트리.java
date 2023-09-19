import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> orderMap = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < skill.length(); i++) {
            orderMap.put(skill.charAt(i), i);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            int curOrder = 0;
            boolean canLearn = true;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (!orderMap.containsKey(skill_trees[i].charAt(j))) continue;

                if (orderMap.get(skill_trees[i].charAt(j)) == curOrder) curOrder++;
                else canLearn = false;
            }
            if (canLearn) answer++;
        }
        return answer;
    }
}