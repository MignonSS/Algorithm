class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase() // step 1
                        .replaceAll("[^a-zA-Z0-9\\-_.]", "") // step 2
                        .replaceAll("\\.+", ".") // step 3
                        .replaceAll("^\\.|\\.$", ""); // step 4

        if (new_id.length() == 0) new_id = "a"; // step 5

        if (new_id.length() >= 16) { // step 6
            new_id = new_id.replaceAll("^(.{15}).*$", "$1")
                            .replaceAll("\\.$", "");
        }

        if (new_id.length() <= 2) { // step 7
            char c = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) new_id += c;
        }

        return new_id;
    }
}