class Solution {
    public String longestCommonPrefix(String[] v) {
        StringBuilder res=new  StringBuilder();
        Arrays.sort(v);

        char[] first= v[0].toCharArray();
        char[] last= v[v.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i]!=last[i]){
                break;
            }
            res.append(first[i]);
        }
        return res.toString();
    }
}