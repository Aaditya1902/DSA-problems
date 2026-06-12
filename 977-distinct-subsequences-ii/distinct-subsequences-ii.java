class Solution {
    int q = 1000000007;
    public int distinctSubseqII(String s) {
        int[] hash = new int[26]; //to track previously used same character
        Arrays.fill(hash,-1); // all characters are intitally not used
        int[] arr = new int[s.length()+1];
        arr[0]=1;
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)-'a']==-1){
                arr[i+1]=(arr[i]+arr[i])%q;// add num of subsequence that can be formed using i-th character
                hash[s.charAt(i)-'a']=i;
            }else{
                arr[i+1]=(arr[i]+arr[i])%q;
                arr[i+1]-=arr[hash[s.charAt(i)-'a']]; // if i-th character is repeatition of previous charcter then subtract the number of subsequence that you added previously as that number of subsequeces are not distinct 
                if(arr[i+1]<0){
                    arr[i+1]+=q;
                }
                hash[s.charAt(i)-'a']=i;
            }
        }
        // System.out.println(Arrays.toString(arr));
        return arr[arr.length-1]-1<0?arr[arr.length-1]-1+q:arr[arr.length-1]-1;
    }
}