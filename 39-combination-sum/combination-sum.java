class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        comb(list,new ArrayList<>(),candidates,target,0);
        return list;
    }

    private void comb(List<List<Integer>> list,List<Integer> templist,int[] nums, int target, int start){
        if(target<0){
            return;
        }else if(target == 0){
            list.add(new ArrayList<>(templist));
            return;
        }else{
            for(int i=start;i<nums.length;i++){
                templist.add(nums[i]);
                comb(list,templist,nums,target-nums[i],i);
                templist.remove(templist.size()-1);
            }
        }
    }
}