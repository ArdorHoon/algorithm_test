import java.util.*;

class Solution {
    
    static int[] answer = {0,0};
    static Boolean[] visited;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        visited = new Boolean[emoticons.length];
        Arrays.fill(visited, false);
        ArrayList<Integer> percents = new ArrayList<>();

        searchCase(percents, 0, emoticons.length, users, emoticons);

        return answer;
    }
    
    
    public static void calculate(ArrayList<Integer> percents, int[][] users, int[] emoticons){

        int subscriber = 0;
        int price = 0;
        int[] calEmoticons = new int[emoticons.length];

        for(int k = 0 ; k < calEmoticons.length ; k++){
            calEmoticons[k] =(int)(emoticons[k] * (100- percents.get(k)) * 0.01);
        }


        for(int i = 0 ; i < users.length ; i ++){
            int userPercent = users[i][0];
            int userMaximum = users[i][1];
            int sum = 0;

            for(int j = 0 ; j < emoticons.length ; j ++){
                   if(userPercent <= percents.get(j)){
                       sum += calEmoticons[j];
                   }
            }

            if(sum >= userMaximum){
                subscriber++;
            }else{
                price+= sum;
            }

        }

        if(subscriber == answer[0]){
            answer[1] = Math.max(answer[1], price);
        }else if(subscriber > answer[0]){
            answer[0] = subscriber;
            answer[1] = price;
        }
    }


    public static void searchCase(ArrayList<Integer> percents, int index, int max, int[][] users, int[] emoticons){

        if(percents.size() == max){
            calculate(percents, users, emoticons);
        }else{
            for(int i = 1 ; i <= 4  ; i ++){
                if(visited[index]) continue;
                visited[index] = true;
                percents.add(10 * i);
                searchCase(percents, index+1, max, users, emoticons);
                percents.remove(index);
                visited[index] =false;
            }
        }
    }
}