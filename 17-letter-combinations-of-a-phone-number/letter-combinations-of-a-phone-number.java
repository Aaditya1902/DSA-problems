class Solution {
    public List<String> letterCombinations(String digits) {

        
        List<String> res = new ArrayList<>();

        if(digits==null || digits.length()==0){
            return  res;
        }

        Map<Character,String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        generatestring(digits,0,res,new StringBuilder(),map);

        return res;
    }

    void generatestring(String digits, int idx, List<String> res, StringBuilder comb, Map<Character,String> map){
        if(idx==digits.length()){
            res.add(comb.toString());
            return ;
        }
        

        String letters  = map.get((digits.charAt(idx)));
        for(char letter : letters.toCharArray()){
            comb.append(letter);
            generatestring(digits,idx+1,res,comb,map);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}