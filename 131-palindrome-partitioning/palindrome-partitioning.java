class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        part(s,0,res,new ArrayList<>());

        return res;
    }

    boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){   
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    void part(String s,int start,List<List<String>> res, List<String> temps){
        if(start==s.length()){
            res.add(new ArrayList<>(temps));
            return;
        }

        for(int end=start+1;end<=s.length();end++){
            if(isPalindrome(s,start,end-1)){
                temps.add(s.substring(start,end));
                part(s,end,res,temps);
                temps.remove(temps.size()-1);
            }
        }
    }
}