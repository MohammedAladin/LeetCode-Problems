class Solution {
    int ans;
    
    Solution(){
        ans = 0;
    }

    private boolean isValid(List<String> sub, int r, int c, int n){
        int i, j;
        for(i = 0; i<n; ++i){
            if(sub.get(r).charAt(i)=='Q')return false;
        }
        for(i = r, j = c; i>=0 && j>=0; --i, --j){
            if(sub.get(i).charAt(j)=='Q')return false;
        }
        for(i = r, j = c; i<n && j>=0; ++i, --j){
            if(sub.get(i).charAt(j)=='Q')return false;
        }

        return true;
    }
    private void solve(List<String> sub, int col, int n){
        if(col >= n) {
            ans++;
            return;
        }

        for(int row = 0; row<n; ++row){
            if(isValid(sub, row, col, n)){


                StringBuilder sb = new StringBuilder(sub.get(row));
                sb.setCharAt(col, 'Q'); 
                sub.set(row, sb.toString());

                solve(sub, col + 1, n);

                sb.setCharAt(col, '.');
                sub.set(row, sb.toString());

            }
        }
    }
    public int totalNQueens(int n) {
        
        List<String> sub = new ArrayList<>();
        for(int i = 0; i<n; ++i){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j<n; ++j){
                str.append('.');
            }
            sub.add(str.toString());
        }

        solve(sub, 0, n);
        return ans;
   
    }
}