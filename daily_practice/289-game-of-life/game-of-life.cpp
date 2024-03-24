class Solution {
public:
     int nxtGen(int r, int c, int n, int m, int cell,vector<vector<int>>& board){
        int ones = 0;
        for(int i = max(r - 1, 0); i <= min(r + 1, n - 1); ++i) {
            for(int j = max(c - 1, 0); j <= min(c + 1, m - 1); ++j){
                if(i==r && j==c)continue;
                if(board[i][j]==1)ones++;
            }
        }
        if(cell)
        {
            if(ones<2)return 0;
            if(ones ==2 || ones == 3)return 1;
            if(ones>3)return 0;
        }   
        else if(!cell && ones==3) return 1;    
        return cell;
    }
    void gameOfLife(vector<vector<int>>& board) {
        int n = board.size();
        int m = board[0].size();
        vector<vector<int>> board_(n, vector<int>(m));
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; ++j){
                board_[i][j] = nxtGen(i,j,n,m,(board[i][j]==1)?1:0, board);
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; ++j){
                board[i][j] = board_[i][j];
            }
        }
        
    }
};