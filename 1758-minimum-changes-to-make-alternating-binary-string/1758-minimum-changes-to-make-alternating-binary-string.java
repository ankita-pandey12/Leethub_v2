class Solution {
    public int minOperations(String s) {
        int cnt1 = 0; 
        int cnt2 = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char exp1 = (i % 2 == 0) ? '0' : '1';
            char exp2 = (i % 2 == 0) ? '1' : '0';
            
            if(s.charAt(i) != exp1)
                cnt1++;
            
            if(s.charAt(i) != exp2)
                cnt2++;
        }
        
        return Math.min(cnt1, cnt2);
    }
}