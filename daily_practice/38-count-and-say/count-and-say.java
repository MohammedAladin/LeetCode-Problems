class Solution {
      String ans="";
    private void solve(int itr, int n, String seq){

        if(itr == n) {
            ans = seq;
            return;
        }
        String str="";
        int cnt = 1;
        char c = seq.charAt(0);
        for(int i = 1; i<seq.length(); ++i){
            if(c != seq.charAt(i)){
                str+=String.valueOf(cnt)+c;
                c = seq.charAt(i);
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        str+=String.valueOf(cnt)+c;
        solve(itr+1, n, str);


    }

    public String countAndSay(int n) {
        solve(1,n,"1");
        return ans;
    }
}