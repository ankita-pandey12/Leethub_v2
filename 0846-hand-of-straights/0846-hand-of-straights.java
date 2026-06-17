class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int l = hand.length;
        if(l % groupSize !=0)
            return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num: hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;
                if (!map.containsKey(card)) 
                    return false;
                if (map.get(card) == 1) map.remove(card);
                else map.put(card, map.get(card) - 1);
            }
        }
        return true;
    }
}