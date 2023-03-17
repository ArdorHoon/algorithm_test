class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        if(m==1) return section.length;

        int last = -1;
        for(int i =0 ; i < section.length ; i++){
            
            if(last > n){
                break;
            }
            
            if(last == -1){
                answer++;
                last = section[i] + m; 
            }
            else{

                if(section[i] >= last){
                    answer++;
                    last = section[i] +m;
                }
            }
        }


        return answer;
    }
}