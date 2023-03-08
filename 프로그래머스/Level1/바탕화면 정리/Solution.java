import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int[] answer = {-1, -1, -1, -1};
        String[][] walls = new String[wallpaper.length][wallpaper[0].length()];

        int x = wallpaper.length;
        int y = wallpaper[0].length();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                walls[i][j] = String.valueOf(wallpaper[i].charAt(j));
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            if (wallpaper[i].contains("#")) {
                temp.add(i);
            }
        }
        if (temp.size() != 0) {
            answer[0] = temp.get(0);
            answer[2] = temp.get(temp.size() - 1) + 1;
        }
        temp.clear();


        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (walls[i][j].equals("#")) {
                    temp.add(j);
                    break;
                }
            }
        }
        if (temp.size() != 0) {
            answer[1] = temp.get(0);
            answer[3] = temp.get(temp.size() - 1) +1;
        }

        return answer;
    }
}