class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        int cnt=0;
        for(char c : word.toCharArray()){
            if(c>='a' && c<='z'){
                arr[c-'a']++;
            }
            else{
                arr2[c-'A']++;
            }
        }

        for(int i=0;i<26;i++){
            if(arr[i] > 0 && arr2[i] > 0)
                cnt++;
        }
        return cnt;
    }
}