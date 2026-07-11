class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();

        int prefixsum=0;

        int count=0;

        hm.put(0,1);

        for(int i=0;i<nums.length;i++){
            prefixsum+=nums[i];

            int remove = prefixsum-k;

            if(hm.containsKey(remove)){
                count+=hm.get(remove);
            }

            hm.put(prefixsum, hm.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}