class Solution {
    int[][] visited = new int[10][10];
    char[][] board;
    String word;
    int n, m;

    boolean check(int i, int j, StringBuilder s) {

        if(i>=n || i<0 || j>=m || j<0 || visited[i][j]==1) return false;
    
        s.append(board[i][j]);
        if (s.length() == word.length()) {
            if (s.toString().equals(word)) {
                return true;
            }
            return false;
        }

        visited[i][j] = 1;

        boolean ret = false;
        ret|=check(i + 1, j, new StringBuilder(s));
        ret|=check(i - 1, j, new StringBuilder(s));
        ret|=check(i, j + 1, new StringBuilder(s));
        ret|=check(i, j - 1, new StringBuilder(s));

        visited[i][j] = 0;

        return ret;

    }
    public boolean exist(char[][] board, String word) {


        this.board = board;
        this.word = word;

        n = board.length;
        m = board[0].length;

        for (int[] row : visited) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0)== board[i][j] && check(i, j, new StringBuilder()))
                    return true;
            }
        }
        return false;
    }
}