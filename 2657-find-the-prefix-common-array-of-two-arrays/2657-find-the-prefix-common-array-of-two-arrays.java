class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C = new int[A.length];
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<A.length;i++){
            int cnt=0;
            hs.add(A[i]);
            for(int j=0;j<=i;j++){
                    if(hs.contains(B[j]))
                    cnt++;
            }
            C[i]=cnt;
        }
        return C;
    }
}