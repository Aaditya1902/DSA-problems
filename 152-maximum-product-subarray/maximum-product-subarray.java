class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;

        int max=nums[0];
        if(nums.length==1){
                return nums[0];
            }
        for(int i=0;i<n;i++){
            
            // if(nums[i]==0){
            //     continue;
                
            // }
            int prod=nums[i];
            max=Math.max(max,prod);
            for(int j=i+1;j<n;j++){
                
                prod*=nums[j];
                max=Math.max(max,prod);
               
                 
            }
        }
        return max;
    }
}