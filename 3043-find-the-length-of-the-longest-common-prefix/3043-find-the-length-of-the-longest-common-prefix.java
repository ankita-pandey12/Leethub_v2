class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max =0;
        HashSet<String> set = new HashSet<>();
        for(int n:arr1){
            String s = Integer.toString(n);

            for(int i=0;i<s.length();i++){
                set.add(s.substring(0,i+1));
            }
        }

        for(int n:arr2){
            String s = Integer.toString(n);

            for(int i=0;i<s.length();i++){
                if(set.contains(s.substring(0,i+1))){
                    max=Math.max(max,i+1);
                }
                else
                    break;
            }
        }
        return max;
    }
}