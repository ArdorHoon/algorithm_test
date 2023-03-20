import java.util.Arrays;

class Solution {
    public String solution(int n) {
            String[] num = {"1","2","4"};

        StringBuilder answer = new StringBuilder();

        int sum = 0;
        int i = 1;

        while(n > sum + Math.pow(3,i)){
            sum +=  Math.pow(3, i);
            i++;
        }

        int[] cal = new int[i];
        Arrays.fill(cal, 0);
        int diff= n - (sum+1);

        if(i==1){
            cal[0] += diff;
        }else{
            for(int k = 0 ; k< i-1 ; k++){
                if(k==0){
                    cal[k] += diff;
                    int q = cal[k]/3;
                    int r = cal[k]%3;
                    cal[k] = r;
                    cal[k+1] += q;
                }else{
                    int q = cal[k]/3;
                    int r = cal[k]%3;
                    cal[k] = r;
                    cal[k+1] += q;
                }
            }
        }

        for(int v = cal.length-1 ; v >= 0 ; v--){
            answer.append(num[cal[v]]);
        }

        return answer.toString();
    }
}