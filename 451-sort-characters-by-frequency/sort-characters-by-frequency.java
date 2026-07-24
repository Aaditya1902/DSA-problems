class Solution {
    public String frequencySort(String s) {
         int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        //         What it does: It creates a frequency array of size 128 (which covers all standard ASCII characters).
        // The Trick: In Java, a char is secretly just a number under the hood (e.g., 'a' is 97, 'b' is 98). By writing freq[c]++, Java automatically converts the character into its ASCII numeric index. If the string contains 'a', freq[97] increases by 1.

        char[] res = new char[s.length()];
        int index = 0;

        while (index < s.length()) {
            int max = 0;
            int maxCharIdx = 0;

            for (int i = 0; i < 128; i++) {
                if (freq[i] > max) {
                    max = freq[i];
                    maxCharIdx = i;
                }
            }

            while (freq[maxCharIdx] > 0) {
                res[index++] = (char) maxCharIdx;
                freq[maxCharIdx]--;
            }
        }

        return new String(res);
    }
}