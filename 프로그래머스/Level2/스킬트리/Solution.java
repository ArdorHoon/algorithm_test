import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Character[] skillSet = new Character[skill.length()];
        int start;

        for(int k = 0 ; k < skill.length(); k++){
            skillSet[k] =  skill.charAt(k);
        }

        for(int i = 0 ; i <skill_trees.length ;i ++){
            start = 0;
            for(int j = 0 ; j < skill_trees[i].length(); j ++){

                Character a = skill_trees[i].charAt(j);
                if(skill.contains(String.valueOf(a))){

                    int b = skill.indexOf((String.valueOf(a)));;

                    if(start == b){
                        start++;
                    }else{
                        break;
                    }
                }

                if(j == skill_trees[i].length()-1){
                    answer++;
                }
            }
        }

        return answer;
    }
}