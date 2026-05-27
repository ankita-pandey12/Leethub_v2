class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int cnt =0;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c>='a' && c<='z'){
                arr1[c-'a']++;
                if(arr2[c-'a'] > 0)
                    arr1[c-'a']=0;
            }
            else{
                int a = c-'A';
                arr2[a]++;
            }
        }

        for(int i=0;i<26;i++){
            if(arr1[i]>0 && arr2[i] >0)
                cnt++;
        }
        return cnt;
    }
}