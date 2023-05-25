class Solution {
    public int[] solution(String[] wallpaper) {
        int left = wallpaper[0].length(), right = 0, top = wallpaper.length, bottom = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                int curFstFileIdx = wallpaper[i].indexOf('#');
                int curLastFileIdx = wallpaper[i].lastIndexOf('#');
                if (curFstFileIdx != -1) {
                    top = Math.min(top, i);
                    bottom = Math.max(top, i);
                    left = Math.min(left, curFstFileIdx);
                    right = Math.max(right, curLastFileIdx);
                }
            }
        }

        return new int[]{top, left, bottom+1, right+1};
    }
}