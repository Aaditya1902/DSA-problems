class Solution {

    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (int n : nums) {

            if (map.containsKey(n)) continue;

            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);

            int sum = left + right + 1;

            map.put(n, sum);

            // update boundaries
            map.put(n - left, sum);
            map.put(n + right, sum);

            max = Math.max(max, sum);
        }

        return max;
    }
}