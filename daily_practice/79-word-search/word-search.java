class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        
        if (search(board, word)){
            return true;
        }
    
        return false;
    }

    private boolean search(char[][] board, String word) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; 

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (dfs(board, word, index + 1, ni, nj)) {
                board[i][j] = temp; 
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
