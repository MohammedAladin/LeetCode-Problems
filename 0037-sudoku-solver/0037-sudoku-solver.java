class Solution {
        private static boolean isValid(int i, int j, char[][] board, char c){

        int rb;
        int cb;

        if(i<3) rb = 0;
        else if(i<6) rb = 3;
        else rb = 6;

        if(j<3) cb = 0;
        else if(j<6) cb = 3;
        else cb = 6;

        for(int k=0;k<9;k++) if(board[i][k]==c) return false;
        for(int k=0;k<9;k++) if(board[k][j]==c) return false;

        for(int k = rb; k<rb+3; k++){
            for(int k2 = cb; k2<cb+3; k2++){
                if(board[k][k2]==c) return false;
            }
        }


        return true;
    }
    private static boolean solve(char[][] board) {


        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.'){
                    boolean valid = false;
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(i, j, board, c)){
                            valid = true;
                            board[i][j] = c;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                   return false; // backtrack
                }

            }
        }
        return true;

    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}