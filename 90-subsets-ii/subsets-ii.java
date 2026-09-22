class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        backtrack(res,new ArrayList<>(),nums,0);

        return res;
    }

    private void backtrack(List<List<Integer>> res,List<Integer> tempset,int[] nums, int start){

        if(res.contains((tempset))) return;
        res.add(new ArrayList<>(tempset));
        

        for(int i=start;i<nums.length;i++){
            tempset.add(nums[i]);

            backtrack(res,tempset,nums,i+1);

            tempset.remove(tempset.size()-1);
        }
    }
}