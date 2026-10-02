class Solution {
    public boolean canJump(int[] nums) {
        int maxjump=0;

        for(int i=0;i<nums.length;i++){
            if(i>maxjump){
                return false;
            }

            maxjump=Math.max(maxjump,nums[i]+i);

            if(maxjump>=nums.length-1){
                return true;
            }
        }

        return true;
    }
}