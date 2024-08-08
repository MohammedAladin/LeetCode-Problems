class Solution {
    List<List<String>> ans;
    int N;
    public Solution(){
        ans = new ArrayList<List<String>>();
        
    }
    private boolean isValid(List<String> sub, int r, int c){
        int i, j;
        for(i = 0; i<N; ++i){
            if(sub.get(r).charAt(i)=='Q')return false;
        }
        for(i = r, j = c; i>=0 && j>=0; --i, --j){
            if(sub.get(i).charAt(j)=='Q')return false;
        }
        for(i = r, j = c; i<N && j>=0; ++i, --j){
            if(sub.get(i).charAt(j)=='Q')return false;
        }

        return true;
    }
    private void search(List<String> sub, int col){


        if (col >= N) {
            ans.add(new ArrayList<>(sub)); // Add a copy of sub
            return;
        }

        for(int row = 0; row<N; ++row){
            if(isValid(sub, row, col)){


                StringBuilder sb = new StringBuilder(sub.get(row));
                sb.setCharAt(col, 'Q'); 
                sub.set(row, sb.toString());

                search(sub, col + 1);

                sb.setCharAt(col, '.');
                sub.set(row, sb.toString());

            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        List<String> sub = new ArrayList<>();
        for(int i = 0; i<n; ++i){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j<n; ++j){
                str.append('.');
            }
            sub.add(str.toString());
        }

        search(sub, 0);
        return ans;
    }
}