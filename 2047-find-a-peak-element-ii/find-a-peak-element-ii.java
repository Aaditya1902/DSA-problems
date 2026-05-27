class Solution {

    // Find row index of maximum element in a column
    private int findMaxIndex(int[][] mat, int n, int col) {

        int maxValue = -1;
        int index = -1;

        for (int i = 0; i < n; i++) {

            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                index = i;
            }
        }

        return index;
    }

    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // Binary Search on columns
        int low = 0;
        int high = m - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find maximum element row in middle column
            int maxRowIndex = findMaxIndex(mat, n, mid);

            // Left neighbor
            int left = (mid - 1 >= 0)
                    ? mat[maxRowIndex][mid - 1]
                    : -1;

            // Right neighbor
            int right = (mid + 1 < m)
                    ? mat[maxRowIndex][mid + 1]
                    : -1;

            // Peak element found
            if (mat[maxRowIndex][mid] > left &&
                mat[maxRowIndex][mid] > right) {

                return new int[]{maxRowIndex, mid};
            }

            // Move towards bigger left element
            else if (mat[maxRowIndex][mid] < left) {
                high = mid - 1;
            }

            // Move towards bigger right element
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}