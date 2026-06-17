class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int c:costs){
            pq.add(c);
        }
        int avail = coins;
        int cnt=0;
        while(avail>0 && !pq.isEmpty()){
            int temp = pq.poll();
            if(temp<=avail){
                avail=avail-temp;
                cnt++;
            }
        }
        return cnt;
    }
}