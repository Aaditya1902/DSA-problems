class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==words[0] && recur(board,i,j,words,0)){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean recur(char[][] board,int i,int j,char[] words,int idx){
        if(idx==words.length){
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=words[idx]  ||  board[i][j]=='*'){
            return false;
        }

        char temp=board[i][j];
        board[i][j]='*';

        if(recur(board,i+1,j,words,idx+1) || 
            recur(board,i-1,j,words,idx+1) || 
            recur(board,i,j+1,words,idx+1) || 
            recur(board,i,j-1,words,idx+1)  ){
                return true;
            }

        board[i][j]=temp;

        return false;
    }
}