import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] arr = new String[files.length][4];

        for (int idx = 0; idx < files.length; idx++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            String tail = "";
            boolean meetNum = false;

            for (int i = 0; i < files[idx].length(); i++) {
                String curStr = files[idx];

                if (!meetNum && Character.isDigit(curStr.charAt(i))) { // number
                    while (i < curStr.length() && Character.isDigit(curStr.charAt(i))) {
                        number.append(curStr.charAt(i++));
                    }
                    meetNum = true;
                } else if (!meetNum) { // head
                    head.append(files[idx].charAt(i));
                } else {
                    tail = files[idx].substring(i);
                    break;
                }
            }
            
            arr[idx][0] = head.toString().toUpperCase();
            arr[idx][1] = number.toString();
            arr[idx][2] = tail;
            arr[idx][3] = String.valueOf(idx);
        }

        return Arrays.stream(arr)
                .sorted(Comparator
                        .comparing((String[] a) -> a[0])
                        .thenComparing((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1])))
                .map(v -> files[Integer.parseInt(v[3])])
                .toArray(String[]::new);
    }
}