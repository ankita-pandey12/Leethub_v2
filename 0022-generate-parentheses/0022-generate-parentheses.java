class Solution {
    List<String> ls;
    public void helper(int n,int c,int a,String curr){
        if(a==n && c==0){
            ls.add(curr);
            return;
        }
        if(a==n && c>0){
            helper(n,c-1,a,curr+')');
        }
        else{
            if(c>0){
            helper(n,c-1,a,curr+')');
            }
            helper(n,c+1,a+1,curr+'(');
        }
        return;  
}
    public List<String> generateParenthesis(int n) {
        ls=new ArrayList<>();
        helper(n,0,0,"");
        return ls;
    }
}