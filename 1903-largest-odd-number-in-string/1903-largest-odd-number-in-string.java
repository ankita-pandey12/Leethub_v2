class Solution {
    public String largestOddNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>-1;i--){
            int n = s.charAt(i)-'0';
            if(n%2!=0){
                return s.substring(0,i+1);
            }
        }
        return "";
    }
}