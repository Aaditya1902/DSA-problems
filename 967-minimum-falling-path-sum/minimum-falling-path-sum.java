class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row =matrix.length;
        int col=row;

        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }else if(j==col-1){
                    matrix[i][j] +=Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));
                }
            }
        }
        int ans=matrix[row-1][0];

        for(int i=1;i<col;i++){
            ans = Math.min(ans, matrix[row-1][i]);
        }

        return ans;
    }
}