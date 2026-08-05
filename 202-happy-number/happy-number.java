class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        
        if(n==1){
            return true;
        }
        
        int sum=0;
        int num=n;
        
        while(sum!=1){

            if(set.contains(num)){
                return false;
            }
            set.add(num);
            sum=0;
            
            while(num>0){
                int digit=num%10;
                num=num/10;
                sum+=digit*digit;
                
            }
            num=sum;

            


        }
        return true;
    }
}