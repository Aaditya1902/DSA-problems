class Solution {
    public int rob(int[] nums) {
        if (nums.length<2){
            return nums[0];
        }

        int[] skiplast = new int[nums.length-1];
        int[] skipfirst = new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++){
            skiplast[i]  = nums[i];
            skipfirst[i] = nums[i+1];
        }
        int skipfirstmoney=rob1(skipfirst);
        int skiplastmoney= rob1(skiplast);

        return Math.max(skiplastmoney,skipfirstmoney);
    }

    public int rob1(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }

        int[] dp=new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];
    }
}