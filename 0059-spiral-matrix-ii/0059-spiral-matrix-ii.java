class Solution {
    int n;
     int[][] ans;
    int start;
    int num;
    boolean[][] vis;

    public Solution() {
        // Constructor to initialize variables
        this.n = 0;
        this.start = 0;
        this.num = 1;
        this.ans = new int[0][0];
        this.vis = new boolean[21][21];
    }

    public void filling(int i, int j) {
        if (i >= n || j >= n || i < 0 || j < 0 || vis[i][j]) return;

        vis[i][j] = true;
        ans[i][j] = num++;

        if (i == start && j != n - start - 1) {
            filling(i, j + 1);
        } else if (j == n - start -1 && i != n -start- 1) {
            filling(i + 1, j);
        } else if (i == n - start - 1 && j!=start) {
            filling(i, j - 1);
        } else if (j == start) {
            filling(i - 1, j);
        }
    }

    public int[][] generateMatrix(int n) {
        this.n = n;
        this.ans = new int[n][n];
        this.vis = new boolean[n][n];

        this.start = 0;
        filling(0, 0);
        while(num <= n*n){
            filling(start,start);
            start++;
        }

        return ans;
    }

}