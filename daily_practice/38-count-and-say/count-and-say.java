class Solution {
   public String countAndSay(int n) {
        String ans = "1";  // Initial sequence
        
        for (int itr = 1; itr < n; itr++) {
            StringBuilder str = new StringBuilder();
            int cnt = 1;
            char c = ans.charAt(0);
            
            for (int i = 1; i < ans.length(); i++) {
                if (c != ans.charAt(i)) {
                    str.append(cnt).append(c);
                    c = ans.charAt(i);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            str.append(cnt).append(c);
            ans = str.toString();
        }
        
        return ans;
    }
}