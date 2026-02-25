class Solution {
    List<String> ls;
    public void helper(int index,String curr,int n,int prev){
        if(index==n){
            ls.add(curr);
            return;
        }
        if(prev!=0){
            helper(index+1,curr+'0',n,0);
        }
        helper(index+1,curr+'1',n,1);
    }
    public List<String> validStrings(int n) {
        ls=new ArrayList<>();
        helper(0,"",n,1);
        return ls;
    }
}