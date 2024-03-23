class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder(s); // Create a mutable copy of s

        for(int i =0; i<order.length(); ++i){
            for(int j = 0; j<s.length(); ++j){
                if(order.charAt(i) == temp.charAt(j)){
                    ans.append(s.charAt(j));
                    temp.setCharAt(j, '#'); // Modify the mutable copy
                }
            }
        }
        for(int i = 0; i<s.length(); ++i){
            if(temp.charAt(i)!='#')
                ans.append(s.charAt(i));

        }
        return ans.toString();
    }
}