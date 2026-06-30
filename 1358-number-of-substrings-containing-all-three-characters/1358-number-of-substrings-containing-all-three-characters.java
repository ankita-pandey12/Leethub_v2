class Solution {
    public int numberOfSubstrings(String s) {
        int num=0;
        int[] count = new int[3];
        int i=0;
        for(int j=0;j<s.length();j++){
            count[s.charAt(j)-'a']++;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                num+=s.length()-j;
                count[s.charAt(i)-'a']--;
                i++;
            }
        }
        return num;
    }
}