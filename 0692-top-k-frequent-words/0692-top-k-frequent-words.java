class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            int freqA = map.get(b);
            int freqB = map.get(a);
            if(freqA!=freqB){
                return freqA-freqB;
            }
            else return a.compareTo(b);
        });
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        for(String key : map.keySet()){
            pq.add(key);
        }
        for(int i=0;i<k;i++){
            ans.add(pq.poll());
        }
        return ans;
    }
}