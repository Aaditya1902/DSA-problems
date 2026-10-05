class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;

        int count=0;

        Set<Character> set = new HashSet<>();

        for(end=0;end<s.length();end++){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }

            set.add(s.charAt(end));

            count=Math.max(count,end-start+1);


        }

        return count;


    }
}