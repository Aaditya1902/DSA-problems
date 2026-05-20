class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int findMax(int piles[]) {
        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
}