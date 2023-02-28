import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String n = keymap[i];
            for (int j = 0; j < n.length(); j++) {
                if (hash.containsKey(n.charAt(j))) {
                    if (hash.get(n.charAt(j)) >= j + 1) {
                        hash.put(n.charAt(j), j + 1);
                    }
                } else {
                    hash.put(n.charAt(j), j + 1);
                }
            }
        }


        for(int i = 0 ; i <targets.length; i ++){
            String t = targets[i];
            int num = 0;
            for (int j = 0; j < t.length(); j++) {
                if(hash.containsKey(t.charAt(j))){
                    num += hash.get(t.charAt(j));
                }else{
                    num = 0;
                    break;
                }
            }

            if(num != 0) answer[i] = num;
            else answer[i] = -1;
        }

        return answer;
    }
}