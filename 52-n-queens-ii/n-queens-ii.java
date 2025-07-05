class Solution {
     // chess board
    boolean board[][];
    public int totalNQueens(int n) {
        board = new boolean[n][n];
      return  helper(0,n);
    }
    boolean willIPlaceAQueen(int row,int col){
        // above row
        for(int i= row;i>= 0;i--){
            if(board[i][col]){
                return false;
            }
        }
        // left diagonal
        for(int i= row,j = col;i>=0 && j>= 0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        //right diagonal
        for(int i= row,j=col;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;

    }
    int helper(int row,int n){
        if(row == n){
            return 1;
        }
        int count =0;
        // try to place the queen on column
        for(int col=0;col<n;col++){
        if(willIPlaceAQueen(row,col)){
            board[row][col] = true;
            count = count + helper(row+1,n);
             board[row][col] = false;
        }
        }
        return count;
    }
} 
    