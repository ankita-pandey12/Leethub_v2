class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 || needle.length()==0)
            return 0;
        if(haystack.contains(needle)){
            for(int i=0;i<=haystack.length()-needle.length();i++){
                if(haystack.charAt(i)==needle.charAt(0)){
                    String res = haystack.substring(i,i+needle.length());
                    if(res.equals(needle))
                        return i;
                }
            }
        }
        return -1;
    }
}