class Solution {
    void dfs(int[][] image, int i,int j,int color,int og){
        if(i<0 || i>image.length-1 || j<0 || j>image[0].length-1 || image[i][j]!=og )
            return;
        image[i][j]=color;
        dfs(image,i-1,j,color,og);
        dfs(image,i+1,j,color,og);
        dfs(image,i,j-1,color,og);
        dfs(image,i,j+1,color,og);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}