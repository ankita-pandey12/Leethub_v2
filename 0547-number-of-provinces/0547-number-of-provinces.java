class Solution {

    void bfs(int start , int[][] isConnected, boolean[] visited){
         Queue<Integer> q = new LinkedList<>();
         q.add(start);
         visited[start]=true;
         while(!q.isEmpty()){
            int node = q.poll();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        boolean visited[] = new boolean[isConnected.length];
        
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                province++;
                bfs(i,isConnected,visited);
            }
        }
        return province;
    }
}