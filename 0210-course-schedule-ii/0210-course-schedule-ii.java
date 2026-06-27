class Solution { 
   
    private boolean detectCycle(List<List<Integer>> adj, boolean[] v, boolean[] path, int curr) { 
        v[curr] = true; 
        path[curr] = true; 
        
        for (int i : adj.get(curr)) { 
            if (!v[i]) { 
                if (detectCycle(adj, v, path, i)) return true;
            } else if (path[i]) {
                return true; 
            } 
        } 
        path[curr] = false; 
        return false; 
    } 

    private void topo(List<List<Integer>> adj, int curr, boolean[] v, Stack<Integer> s) { 
        v[curr] = true; 
        for (int i : adj.get(curr)) { 
            if (!v[i]) { 
                topo(adj, i, v, s); 
            } 
        } 
        s.push(curr); 
    } 

    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        List<List<Integer>> adj = new ArrayList<>(); 
        Stack<Integer> s = new Stack<>(); 
        
        for (int i = 0; i < numCourses; i++) { 
            adj.add(new ArrayList<>()); 
        } 
        
        for (int i = 0; i < prerequisites.length; i++) { 
            int dest = prerequisites[i][0]; 
            int src = prerequisites[i][1]; 
            adj.get(src).add(dest); 
        } 
        
        boolean[] visitedForCycle = new boolean[numCourses];
        boolean[] path = new boolean[numCourses]; 
        for (int i = 0; i < numCourses; i++) { 
            if (!visitedForCycle[i]) { 
                if (detectCycle(adj, visitedForCycle, path, i)) {
                    return new int[0]; 
                }
            } 
        } 
        
        boolean[] v1 = new boolean[numCourses]; 
        for (int i = 0; i < numCourses; i++) { 
            if (!v1[i]) { 
                topo(adj, i, v1, s); 
            } 
        } 
        
        int[] arr = new int[numCourses]; 
        int index = 0;
        while (!s.isEmpty()) { 
            arr[index++] = s.pop(); 
        } 
        
        return arr; 
    } 
}
