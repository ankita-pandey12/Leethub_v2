class Solution {
    Map<String, List<Integer>> dp = new HashMap<>();
    List<Integer> helper(int prev, int curr, int[] nums) {
        if (curr == nums.length) {
            return new ArrayList<>();
        }
        String key = prev + "|" + curr;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List<Integer> notTake = helper(prev, curr + 1, nums);

        List<Integer> take = new ArrayList<>();
        if (prev == -1 || nums[curr] % nums[prev] == 0) {
            take = new ArrayList<>(helper(curr, curr + 1, nums));
            take.add(0, nums[curr]); 
        }
        List<Integer> res = (take.size() > notTake.size()) ? take : notTake;
        dp.put(key, res);
        return res;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return helper(-1, 0, nums);
    }
}