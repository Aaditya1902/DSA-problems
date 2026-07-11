class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // HashMap will store all the prefixSum upto the index <Sum, Frequency>
        HashMap<Integer,Integer> hm = new HashMap<>();

        int prefixsum=0;// Actual Sum upto the Index

        int count=0;

// If prefixSum - k = 0, it means the subarray starts from index 0.
        // We add (0, 1) to handle this case naturally.
        hm.put(0,1);

        for(int i=0;i<nums.length;i++){
            prefixsum+=nums[i];

            int remove = prefixsum-k;

// If HashMap contains the exact prefixSum to remove, it means we found valid subarrays
            if(hm.containsKey(remove)){
                count+=hm.get(remove);
            }

// Store/Update the current prefixSum frequency in the map
            hm.put(prefixsum, hm.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}