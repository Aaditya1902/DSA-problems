class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int open = 0;

        for(Character ch : s.toCharArray()){
            if(ch  == '('){
                if(open > 0)
                    str.append('(');

                open++;
            }else{
                open--;

                if(open > 0)
                    str.append(')');
            }
        }

        return str.toString();
    }
}