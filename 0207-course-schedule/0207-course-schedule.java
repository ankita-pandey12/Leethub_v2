class Solution {
    boolean detect(int start,boolean[] visited,boolean[] path, List<List<Integer>> adj){
        visited[start]=true;
        path[start]=true;

        for(int i: adj.get(start)){
            if(!visited[i]){
                if(!detect(i,visited,path,adj))
                    return false;
            }
            else if(path[i])
                return false;
        }

        path[start]=false;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited= new boolean[numCourses];
        boolean[] path= new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
                int u= prerequisites[i][0];
                int v= prerequisites[i][1];
                adj.get(v).add(u);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(!detect(i,visited,path,adj))
                    return false;
            }
        }
        return true;
    }
}