import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String calledName : callings) {
            int calledRank = rank.get(calledName);
            changeRank(calledRank, calledName, players, rank);
        }

        return players;
    }
    
    
        private void changeRank(int calledRank, String calledName, String[] players, Map<String, Integer> rank) {
        String front = players[calledRank - 1];
        players[calledRank - 1] = calledName;
        players[calledRank] = front;

        rank.put(calledName, calledRank - 1);
        rank.put(front, calledRank);
    }
}