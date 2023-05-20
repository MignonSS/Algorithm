class Solution {
    public int solution(String[] babbling) {
        String[] avail = {"aya", "ye", "woo", "ma"};

        int count = 0;

        for (int i = 0; i < babbling.length; i++) {

            String preBabbling =  "";

            while (true) {

                if (babbling[i].startsWith(avail[0]) && !avail[0].equals(preBabbling)) {
                    preBabbling = avail[0];
                    babbling[i] = babbling[i].substring(avail[0].length());
                }
                else if (babbling[i].startsWith(avail[1]) && !avail[1].equals(preBabbling)) {
                    preBabbling = avail[1];
                    babbling[i] = babbling[i].substring(avail[1].length());
                }
                else if (babbling[i].startsWith(avail[2]) && !avail[2].equals(preBabbling)) {
                    preBabbling = avail[2];
                    babbling[i] = babbling[i].substring(avail[2].length());
                }
                else if (babbling[i].startsWith(avail[3]) && !avail[3].equals(preBabbling)) {
                    preBabbling = avail[3];
                    babbling[i] = babbling[i].substring(avail[3].length());
                }
                else break;
            }

            if (babbling[i].length() == 0) count++;
        }

        return count;
    }
}