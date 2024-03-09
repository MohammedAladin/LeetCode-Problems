import java.util.Arrays;

class Solution {
    int[][] visited = new int[10][10];
    char[][] board;
    String word;
    int n, m;

    boolean check(int i, int j, int index) {
        if (index == word.length())
            return true;

        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] == 1 || board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = 1;

        boolean ret = check(i + 1, j, index + 1) || check(i - 1, j, index + 1) ||
                      check(i, j + 1, index + 1) || check(i, j - 1, index + 1);

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
                if (check(i, j, 0))
                    return true;
            }
        }

        return false;
    }
}
