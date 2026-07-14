class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        // int j = 1, k = 2;
        long rSum;
        for (int a = 0; a < nums.length ; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int i = a + 1; i < nums.length ; i++) {
                if (i > a + 1 && nums[i] == nums[i - 1])
                    continue;

                int j = i + 1;
                int k = nums.length - 1;

                rSum = (long) target - nums[i] - nums[a];

                while (j < k) {

                    if ((long) nums[j] + nums[k] == rSum) {

                        List<Integer> sum = new ArrayList<>();
                        sum.add(nums[a]);
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[k]);

                        ans.add(sum);

                        j++;
                        k--;

                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }

                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }

                    }

                    else if ((long) (nums[j] + nums[k]) > rSum) {
                        k--;
                    }

                    else {
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}