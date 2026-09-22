class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res =new ArrayList<>();
        subset(1,9,new ArrayList<>(),res,k,n);
        return res;
    }

    void subset(int start,int end,List<Integer> tempset,List<List<Integer>> res,int k,int target){

        if(target==0  && tempset.size()==k){
            res.add(new ArrayList(tempset));
            return;
        }

        for(int i=start;i<=end;i++){
            tempset.add(i);

            subset(i+1,end,tempset,res,k,target-i);
            tempset.remove(tempset.size()-1);
        }
        

    }
}