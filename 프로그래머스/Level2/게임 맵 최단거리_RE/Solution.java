import java.util.*;

class Solution {

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int m =maps.length;
        int n =maps[0].length;
        Boolean[][] visited = new Boolean[m][n];
        int[][] dis = new int[m][n];    
        
        for(int k = 0 ; k < visited.length; k++){
               Arrays.fill(visited[k], false);
               Arrays.fill(dis[k], 0);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0,0};
        visited[0][0] = true;
        dis[0][0] = 1;
        queue.add(start);
        
        while(!queue.isEmpty()){
        
            int[] a = queue.poll();
            int x = a[0];
            int y = a[1];

            for(int i=0; i <4 ; i++){
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if((nx>=0 && nx <m) && (ny>=0 && ny <n) && maps[nx][ny] ==1 && !visited[nx][ny]){
                    int[] b = {0,0};
                    b[0] = nx;
                    b[1] = ny;
                    queue.add(b);
                    visited[nx][ny]= true;
                    dis[nx][ny] = dis[x][y] +1;
                }
                
            }
            
        }
        
        if(dis[m-1][n-1] ==0) return -1;
        else return dis[m-1][n-1];
    }
      
}