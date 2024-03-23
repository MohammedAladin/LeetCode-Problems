class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        
        for(int i =0; i<order.length(); ++i){
            for(int j = 0; j<s.length(); ++j){
                if(order.charAt(i) == s.charAt(j)){
                    ans.append(s.charAt(j));
                    s = s.substring(0, j) + "#" + s.substring(j + 1);
                }
            }
        }
        for(int i = 0; i<s.length(); ++i){
            if(s.charAt(i)!='#')
                ans.append(s.charAt(i));

        }
        return ans.toString();
    }
}